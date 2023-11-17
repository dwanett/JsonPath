package jsonPath;

import antlr.JsonPathParser;
import com.google.gson.JsonElement;

public class JsonPath extends BaseModel<JsonPath> {

    private JsonPathElement jsonPathElement;


    @Override
    public JsonPath visitJsonPath(JsonPathParser.JsonPathContext ctx) {
        jsonPathElement = ctx.jsonPathElement() != null ? new JsonPathElement().visit(ctx.jsonPathElement()) : null;
        jsonPath = this;
        return this;
    }

    public String getValue(JsonElement json) {
        immutableJson = json;
        JsonElement result = jsonPathElement.read(json);
        return convertJsonToString(result);
    }
}
