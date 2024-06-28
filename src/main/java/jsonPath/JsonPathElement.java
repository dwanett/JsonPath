package jsonPath;

import antlr.JsonPathParser;
import com.google.gson.*;
import jsonPath.function.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonPathElement extends BaseModel<JsonPathElement> {
    private String name;

    private String indexArray;

    private boolean isIndexRange = false;

    private int startIndexRange;

    private int endIndexRange;

    private Filter filter = null;

    private JsonPathElement nextJsonPathElement = null;

    @Override
    public JsonPathElement visitJsonPathElement(JsonPathParser.JsonPathElementContext ctx) {

        if (ctx.NAME() != null)
            name = ctx.NAME().getText();
        else if (ctx.NO_NAME() != null)
            name = ctx.NO_NAME().getText();
        else
            name = ctx.STRING().getText().replaceAll("\"", "");

        indexArray = ctx.INDEXARRAY() != null ? ctx.INDEXARRAY().getText().replaceAll("\\[|\\]", "") : null;

        if (indexArray != null) {
            String[] indexRange = indexArray.split(",");

            isIndexRange = indexRange.length > 1;

            if (isIndexRange) {
                startIndexRange = Integer.parseInt(indexRange[0]);
                endIndexRange = Integer.parseInt(indexRange[1]);
            }
        }

        if (ctx.filter() != null) {
            filter = new Filter();
            filter.prevJsonPathElement = this;
            filter.filterRemoving = (this.prevJsonPathElement != null) ? prevJsonPathElement.getFilter() == null : false;
            filter = filter.visit(ctx.filter());
        }

        if (ctx.jsonPathElement() != null) {
            nextJsonPathElement = new JsonPathElement();
            nextJsonPathElement.prevJsonPathElement = this;
            nextJsonPathElement = nextJsonPathElement.visit(ctx.jsonPathElement());
        }

        if (ctx.FUNCTION() != null) {
            if (BaseModel.getLiteralValue(JsonPathParser.SORT).equals(ctx.FUNCTION().getText()))
                jsonPath.get().function = new SortFunction();
            else if (BaseModel.getLiteralValue(JsonPathParser.SIZE).equals(ctx.FUNCTION().getText()))
                jsonPath.get().function = new SizeFunction();
            else if (BaseModel.getLiteralValue(JsonPathParser.DISTINCT).equals(ctx.FUNCTION().getText()))
                jsonPath.get().function = new DistinctFunction();
            else if (BaseModel.getLiteralValue(JsonPathParser.NAMEATTR).equals(ctx.FUNCTION().getText()))
                jsonPath.get().function = new NameFunction();
        }
        return this;
    }

    public JsonElement read(JsonElement curJson) {
        if (filter != null && curJson != null) {
            if (name.equals(BaseModel.getLiteralValue(JsonPathParser.NO_NAME)))
                findPath(curJson);
            JsonElement element = curJson.getAsJsonObject().get(name);
            if (!(element instanceof JsonArray)) {
                diagnosticInformation.set(new DiagnosticInformation(element, jsonPath.get(), this, null));
                return null;
            } else
                filter.filter(element);
        }

        curJson = getJsonElement(curJson);
        if ((indexArray == null
                || (!indexArray.equals(BaseModel.getLiteralValue(JsonPathParser.ALLINDEX)) && isIndexRange == false)
                || (curJson != null && curJson.isJsonObject()))
                && nextJsonPathElement != null)
            results.get().push(nextJsonPathElement.read(curJson));
        else
            results.get().push(curJson);
        if (nextJsonPathElement == null && curJson != null)
            diagnosticInformation.set(new DiagnosticInformation(curJson, jsonPath.get(), null, null));
        else if (curJson == null)
            diagnosticInformation.set(new DiagnosticInformation(curJson, jsonPath.get(), this, null));
        return results.get().pop();
    }

    private JsonElement getJsonElement(JsonElement json) {
        if (json instanceof JsonArray) {
            if (indexArray != null && ((indexArray.equals(BaseModel.getLiteralValue(JsonPathParser.ALLINDEX))) || isIndexRange)) {
                JsonArray jsonArray = new JsonArray();

                if (indexArray.equals(BaseModel.getLiteralValue(JsonPathParser.ALLINDEX)))
                    jsonArray = readRangeElement(json, 0, json.getAsJsonArray().size());
                else if (isIndexRange)
                    jsonArray = readRangeElement(json, startIndexRange, endIndexRange);

                results.get().push(jsonArray);
                return jsonArray;
            } else if (nextJsonPathElement != null || indexArray != null) {
                try {
                    return json.getAsJsonArray().get(indexArray != null ? Integer.parseInt(indexArray) : 0);
                } catch (Exception e) {
                    results.get().push(new JsonObject());
                    return results.get().peek();
                }
            }
        } else if (json instanceof JsonObject) {
            if (name.equals(BaseModel.getLiteralValue(JsonPathParser.NO_NAME)))
                findPath(json);
            JsonElement element = json.getAsJsonObject().get(name);
            if (element instanceof JsonArray) {
                return getJsonElement(element);
            }
            return element;
        } else if (json instanceof JsonPrimitive)
            return null;
        else if (json instanceof JsonNull)
            return json.getAsJsonNull();
        return json;
    }

    private JsonArray readRangeElement(JsonElement json, int start, int end) {
        JsonArray jsonArray = new JsonArray();
        boolean saveIsIndexRange = isIndexRange;
        String saveIndexArray = indexArray;
        isIndexRange = false;

        if (start < 0)
            start = 0;
        if (end > json.getAsJsonArray().size())
            end = json.getAsJsonArray().size();

        for (int i = start; i < end; i++) {
            indexArray = String.valueOf(i);
            Filter saveFilter = filter;
            filter = null;
            jsonArray.add(read(json));
            filter = saveFilter;
        }

        isIndexRange = saveIsIndexRange;
        indexArray = saveIndexArray;

        return jsonArray;
    }

    private void findPath(JsonElement json) {
        for (Map.Entry<String, JsonElement> values : ((JsonObject) json).entrySet()) {
            this.name = values.getKey();
            if (this.nextJsonPathElement == null && filter == null)
                break;
            JsonElement curElement = ((JsonObject) json).get(name);
            if (!(curElement instanceof JsonObject || curElement instanceof JsonArray)) {
                this.name = BaseModel.getLiteralValue(JsonPathParser.NO_NAME);
                continue;
            }

            JsonElement resultFind = this.read(json);
            if (resultFind != null) {
                if (resultFind.isJsonArray()) {
                    List<JsonElement> array = resultFind.getAsJsonArray().asList().stream().distinct().collect(Collectors.toList());
                    if (array.size() == 1 && array.get(0).isJsonNull())
                        continue;
                }
                if (resultFind.isJsonArray() && resultFind.getAsJsonArray().isEmpty())
                    continue;
                break;
            }
        }
    }

    public void replaceNextJsonPathElement(JsonPathElement NewNextJsonPathElement) {
        this.nextJsonPathElement = NewNextJsonPathElement;
    }

    public JsonPathElement getNextJsonPathElement() {
        return nextJsonPathElement;
    }

    public Filter getFilter() {
        return filter;
    }

    public String getName() {
        return name;
    }
}
