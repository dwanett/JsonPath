package jsonPath;

import antlr.JsonPathParser;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import jsonPath.errors.ErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.tree.ParseTree;

public class JsonPath {


    private JsonElement json;

    private static DiagnosticInformation diagnosticInformationStatic;
    private  DiagnosticInformation diagnosticInformation;

    public JsonPath(JsonElement json) {
        this.json = json;
    }

    public JsonPath(String json) {
        this.json = new Gson().fromJson(json, JsonElement.class);
    }

    public static String getValue(JsonElement json, String jsonPath) {
        return BaseModel.convertJsonToString(getValueGson(json, jsonPath));
    }

    public static String getValue(String json, String jsonPath) {
        return BaseModel.convertJsonToString(getValueGson(json, jsonPath));
    }

    public String getValue(String jsonPath) {
        return BaseModel.convertJsonToString(getValueGson(jsonPath));
    }

    public static JsonElement getValueGson(JsonElement json, String jsonPath) {
        JsonPathAll jsonPathAll = createThree(jsonPath);
        JsonElement result = jsonPathAll.read(json);
        diagnosticInformationStatic = jsonPathAll.diagnosticInformation;
        return result;
    }

    public static JsonElement getValueGson(String json, String jsonPath) {
        return getValueGson(new Gson().fromJson(json, JsonElement.class), jsonPath);
    }

    public JsonElement getValueGson(String jsonPath) {
        JsonElement result = getValueGson(json, jsonPath);
        diagnosticInformation = diagnosticInformationStatic;
        return result;
    }

    public static DiagnosticInformation getDiagnosticInformationStatic() {
        return diagnosticInformationStatic;
    }

    public DiagnosticInformation getDiagnosticInformation() {
        return diagnosticInformation;
    }

    private static JsonPathAll createThree(String jsonPath) {
        MyJsonPathLexer lexer = new MyJsonPathLexer(CharStreams.fromString(jsonPath));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JsonPathParser parser = new JsonPathParser(tokens);
        parser.removeErrorListeners();
        parser.setErrorHandler(new DefaultErrorStrategy());
        parser.addErrorListener(new ErrorListener());
        ParseTree tree = parser.jsonPath();
        JsonPathAll jsonPathAll = new JsonPathAll();
        jsonPathAll.visit(tree);
        return jsonPathAll;
    }
}
