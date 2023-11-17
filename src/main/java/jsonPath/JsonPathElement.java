package jsonPath;

import antlr.JsonPathParser;
import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;

public class JsonPathElement extends BaseModel<JsonPathElement> {
    private String name;

    private String indexArray;

    private Filter filter = null;

    private JsonPathElement nextJsonPathElement = null;
    private Function function = null;

    @Override
    public JsonPathElement visitJsonPathElement(JsonPathParser.JsonPathElementContext ctx) {
        name = ctx.NAME() != null ? ctx.NAME().getText() : ctx.STRING().getText();

        indexArray = ctx.INDEXARRAY() != null ? ctx.INDEXARRAY().getText().replaceAll("\\[|\\]", "") : null;

        if (ctx.filter() != null) {
            filter = new Filter().visit(ctx.filter());
            filter.prevJsonPathElement = this;
        }

        if (ctx.jsonPathElement() != null) {
            nextJsonPathElement = new JsonPathElement().visit(ctx.jsonPathElement());
            nextJsonPathElement.prevJsonPathElement = this;
        }

        if (ctx.FUNCTION() != null) {
            if (BaseModel.getLiteralValue(JsonPathParser.SORT).equals(ctx.FUNCTION().getText()))
                function = new SortFunction();
            if (BaseModel.getLiteralValue(JsonPathParser.SIZE).equals(ctx.FUNCTION().getText()))
                function = new SizeFunction();
        }

        return this;
    }

   public JsonElement read(JsonElement curJson) {
        if (filter != null) {
            //Integer bitFilter = 0;
            JsonElement element = curJson.getAsJsonObject().get(name);
            if (!(element instanceof JsonArray))
                return null;
            else {
                List<JsonElement> forRemoved = new ArrayList<>();
                for (int i = 0; i < element.getAsJsonArray().size(); i++) {
/*                    bitFilter |= filter.filter(((JsonArray) element).get(i));
                    bitFilter = bitFilter << 1;*/
                    if (filter.filter(((JsonArray) element).get(i)) == 0)
                        forRemoved.add(element.getAsJsonArray().get(i));
                }

/*                for (int i = 0; i < element.getAsJsonArray().size(); i++) {
                    if (((bitFilter >> element.getAsJsonArray().size() - i) & 1) == 0)
                         forRemoved.add(element.getAsJsonArray().get(i));
                }*/
                for (JsonElement elemRemove : forRemoved)
                    element.getAsJsonArray().remove(elemRemove);
            }
        }

       curJson = getJsonElement(curJson);
       if ((indexArray == null || !indexArray.equals(BaseModel.getLiteralValue(JsonPathParser.ALLINDEX))) && nextJsonPathElement != null)
           results.push(nextJsonPathElement.read(curJson));
       if (nextJsonPathElement == null)
           results.push(curJson);
        return results.pop();
    }

    private JsonElement getJsonElement(JsonElement json) {
        if (json instanceof JsonArray) {
            if (indexArray != null && indexArray.equals(BaseModel.getLiteralValue(JsonPathParser.ALLINDEX))) {
                JsonArray jsonArray = new JsonArray();
                for (int i = 0; i < json.getAsJsonArray().size(); i++) {
                    indexArray = String.valueOf(i);
                    jsonArray.add(read(json));
                }
                indexArray = BaseModel.getLiteralValue(JsonPathParser.ALLINDEX);
                results.push(jsonArray);
                return jsonArray;
            }
            else if (nextJsonPathElement != null){
                try {
                    return json.getAsJsonArray().get(indexArray != null ? Integer.valueOf(indexArray) : 0);
                } catch (Exception e) {
                    results.push(null);
                    return null;
                }
            }
        } else if (json instanceof JsonObject) {
            JsonElement element = json.getAsJsonObject().get(name);
            if (element instanceof JsonArray) {
                return getJsonElement(element);
/*                if (indexArray.equals(BaseModel.getLiteralValue(JsonPathParser.ALLINDEX))) {
                    JsonArray jsonArray = new JsonArray();
                    for (int i = 0; i < element.getAsJsonArray().size(); i++) {
                        indexArray = String.valueOf(i);
                        jsonArray.add(read(ele10ment));
                    }
                    indexArray = BaseModel.getLiteralValue(JsonPathParser.ALLINDEX);
                    return jsonArray;
                }
                else {
                    try {
                        return element.getAsJsonArray().get(Integer.valueOf(indexArray));
                    } catch (Exception e) {
                        results.push(null);
                        return null;
                    }
                }*/
            }
            return element;
        }
        else if (json instanceof JsonPrimitive)
            return json.getAsJsonPrimitive();
        else if (json instanceof JsonNull)
            return json.getAsJsonNull();
        return json;
    }
}