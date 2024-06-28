package jsonPath;

import antlr.JsonPathBaseVisitor;
import antlr.JsonPathParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

import java.util.Stack;

public class BaseModel<T> extends JsonPathBaseVisitor<T> {

    protected static ThreadLocal<JsonElement> immutableJson = new ThreadLocal<>();

    protected static ThreadLocal<Stack<JsonElement>> results = ThreadLocal.withInitial(() -> new Stack<>());

    protected static ThreadLocal<JsonPathAll> jsonPath = new ThreadLocal<>();

    protected JsonPathElement prevJsonPathElement;

    protected static ThreadLocal<DiagnosticInformation> diagnosticInformation = new ThreadLocal<>();

    public static String getLiteralValue(int value) {
        return JsonPathParser.VOCABULARY.getLiteralName(value)
                .substring(1, JsonPathParser.VOCABULARY.getLiteralName(value).length() - 1);
    }

    public static String convertJsonToString(JsonElement json) {
        if (json != null) {
            if (json instanceof JsonPrimitive)
                return json.getAsString();
            else
                return json.toString();
        }
        else
            return "null";
    }
}
