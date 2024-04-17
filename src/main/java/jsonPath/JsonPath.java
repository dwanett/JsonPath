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
        JsonPathAll jsonPathAll = createThree(jsonPath);
        String result = jsonPathAll.read(json);
        diagnosticInformationStatic = jsonPathAll.diagnosticInformation;
        return result;
    }

    public static String getValue(String json, String jsonPath) {
        return getValue(new Gson().fromJson(json, JsonElement.class), jsonPath);
    }

    public String getValue(String jsonPath) {
        String result = getValue(json, jsonPath);
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
