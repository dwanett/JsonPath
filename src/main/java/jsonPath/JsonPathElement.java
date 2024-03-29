package jsonPath;

import antlr.JsonPathParser;
import com.google.gson.*;
import jsonPath.function.*;

import java.util.Map;
public class JsonPathElement extends BaseModel<JsonPathElement> {
    private String name;

    private String indexArray;

    private Filter filter = null;

    private JsonPathElement nextJsonPathElement = null;

    @Override
    public JsonPathElement visitJsonPathElement(JsonPathParser.JsonPathElementContext ctx) {

        if (ctx.NAME() != null)
            name = ctx.NAME().getText();
        else if (ctx.NO_NAME() != null)
            name = ctx.NO_NAME().getText();
        else
            name = ctx.STRING().getText().replaceAll("\"","");

        indexArray = ctx.INDEXARRAY() != null ? ctx.INDEXARRAY().getText().replaceAll("\\[|\\]", "") : null;

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
                jsonPath.function = new SortFunction();
            else if (BaseModel.getLiteralValue(JsonPathParser.SIZE).equals(ctx.FUNCTION().getText()))
                jsonPath.function = new SizeFunction();
            else if (BaseModel.getLiteralValue(JsonPathParser.DISTINCT).equals(ctx.FUNCTION().getText()))
                jsonPath.function = new DistinctFunction();
            else if (BaseModel.getLiteralValue(JsonPathParser.NAMEATTR).equals(ctx.FUNCTION().getText()))
                jsonPath.function = new NameFunction();
        }
        return this;
    }

    public JsonElement read(JsonElement curJson) {
        if (filter != null && curJson != null) {
            if (name.equals(BaseModel.getLiteralValue(JsonPathParser.NO_NAME)))
                findPath(curJson);
            JsonElement element = curJson.getAsJsonObject().get(name);
            if (!(element instanceof JsonArray)) {
                diagnosticInformation = new DiagnosticInformation(element, jsonPath, this, null);
                return null;
            }
            else
                filter.filter(element);
        }

        curJson = getJsonElement(curJson);
        if ((indexArray == null
                || !indexArray.equals(BaseModel.getLiteralValue(JsonPathParser.ALLINDEX))
                || (curJson != null && curJson.isJsonObject()))
                && nextJsonPathElement != null)
                results.push(nextJsonPathElement.read(curJson));
        else
            results.push(curJson);
        if (nextJsonPathElement == null && curJson != null)
            diagnosticInformation = new DiagnosticInformation(curJson, jsonPath, null, null);
        else if (curJson == null)
            diagnosticInformation = new DiagnosticInformation(curJson, jsonPath, this, null);
        return results.pop();
    }

    private JsonElement getJsonElement(JsonElement json) {
        if (json instanceof JsonArray) {
            if (indexArray != null && indexArray.equals(BaseModel.getLiteralValue(JsonPathParser.ALLINDEX))) {
                JsonArray jsonArray = new JsonArray();
                for (int i = 0; i < json.getAsJsonArray().size(); i++) {
                    indexArray = String.valueOf(i);
                    Filter saveFilter = filter;
                    filter = null;
                    jsonArray.add(read(json));
                    filter = saveFilter;
                }
                indexArray = BaseModel.getLiteralValue(JsonPathParser.ALLINDEX);
                results.push(jsonArray);
                return jsonArray;
            } else if (nextJsonPathElement != null || indexArray != null) {
                try {
                    return json.getAsJsonArray().get(indexArray != null ? Integer.parseInt(indexArray) : 0);
                } catch (Exception e) {
                    results.push(new JsonObject());
                    return results.peek();
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
