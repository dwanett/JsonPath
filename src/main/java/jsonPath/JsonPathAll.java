package jsonPath;

import antlr.JsonPathParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

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

        if (function != null)
            result = new JsonPrimitive(String.valueOf(function.run(result)));

        return convertJsonToString(result);
    }
}
