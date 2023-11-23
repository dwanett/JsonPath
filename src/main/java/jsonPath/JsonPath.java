package jsonPath;

import antlr.JsonPathParser;
import com.google.gson.JsonElement;
import jsonPath.errors.ErrorListener;
import jsonPath.errors.ErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class JsonPath {


    public static String getValue(JsonElement json, String jsonPath) {
        return createThree(jsonPath).read(json);
    }

    private static JsonPathAll createThree(String jsonPath) {
        MyJsonPathLexer lexer = new MyJsonPathLexer(CharStreams.fromString(jsonPath));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JsonPathParser parser = new JsonPathParser(tokens);
        parser.removeErrorListeners();
        parser.setErrorHandler(new ErrorStrategy());
        parser.addErrorListener(new ErrorListener());
        ParseTree tree = parser.jsonPath();
        JsonPathAll jsonPathAll = new JsonPathAll();
        jsonPathAll.visit(tree);
        return jsonPathAll;
    }
}
