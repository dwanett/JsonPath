package jsonPath;

import antlr.JsonPathParser;
import com.google.gson.*;
import jsonPath.function.SizeFunction;
import jsonPath.function.SortFunction;

public class JsonPathElement extends BaseModel<JsonPathElement> {
    private String name;

    private String indexArray;

    private Filter filter = null;

    private JsonPathElement nextJsonPathElement = null;

    @Override
    public JsonPathElement visitJsonPathElement(JsonPathParser.JsonPathElementContext ctx) {
        name = ctx.NAME() != null ? ctx.NAME().getText() : ctx.STRING().getText().replaceAll("\"","");

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
            if (BaseModel.getLiteralValue(JsonPathParser.SIZE).equals(ctx.FUNCTION().getText()))
                jsonPath.function = new SizeFunction();
        }

        return this;
    }

    public JsonElement read(JsonElement curJson) {
        if (filter != null && curJson != null) {
            JsonElement element = curJson.getAsJsonObject().get(name);
            if (!(element instanceof JsonArray)) {
                diagnosticInformation = new DiagnosticInformation(element, jsonPath, this, null);
                return null;
            }
            else
                filter.filter(element);
        }

        curJson = getJsonElement(curJson);
        if ((indexArray == null || !indexArray.equals(BaseModel.getLiteralValue(JsonPathParser.ALLINDEX))) && nextJsonPathElement != null)
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
            JsonElement element = json.getAsJsonObject().get(name);
            if (element instanceof JsonArray) {
                return getJsonElement(element);
            }
            return element;
        } else if (json instanceof JsonPrimitive)
            return json.getAsJsonPrimitive();
        else if (json instanceof JsonNull)
            return json.getAsJsonNull();
        return json;
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
