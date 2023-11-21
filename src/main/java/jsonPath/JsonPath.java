package jsonPath;

import antlr.JsonPathLexer;
import antlr.JsonPathParser;
import com.google.gson.JsonElement;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class JsonPath {


    public static String getValue(JsonElement json, String jsonPath) {
        JsonPathLexer lexer = new JsonPathLexer(CharStreams.fromString(jsonPath));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JsonPathParser parser = new JsonPathParser(tokens);
        ParseTree tree = parser.jsonPath();
        JsonPathAll jsonPathAll = new JsonPathAll();
        jsonPathAll.visit(tree);
        return jsonPathAll.read(json);
    }
}
