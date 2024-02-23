package jsonPath;

import antlr.JsonPathParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import jsonPath.function.Function;

public class JsonPathAll extends BaseModel<JsonPathAll> {

    private JsonPathElement jsonPathElement;
    public Function function = null;

    @Override
    public JsonPathAll visitJsonPath(JsonPathParser.JsonPathContext ctx) {
        jsonPath = this;
        jsonPathElement = ctx.jsonPathElement() != null ? new JsonPathElement().visit(ctx.jsonPathElement()) : null;
        jsonPathElement.prevJsonPathElement = null;
        return this;
    }

    public String read(JsonElement json) {
        immutableJson = json.deepCopy();
        JsonElement result = jsonPathElement.read(json.deepCopy());

        if (function != null) {
            Object resultObj = function.run(result);
            result = resultObj instanceof JsonPrimitive ? (JsonPrimitive)resultObj : new JsonPrimitive(String.valueOf(resultObj));
        }

        return convertJsonToString(result);
    }

    public JsonPathElement getJsonPathElement() {
        return jsonPathElement;
    }
}
