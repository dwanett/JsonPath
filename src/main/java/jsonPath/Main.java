package jsonPath;

import antlr.JsonPathLexer;
import antlr.JsonPathParser;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

    public static void main(String[] args) {
        String str = "author.holding[(aaa == \"d\" && {bbb == \"d\" && ccc == \"d\"} && ddd == \"d\" && eee == \"d\")].epkId";
        JsonPathLexer lexer = new JsonPathLexer(CharStreams.fromString(str));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JsonPathParser parser = new JsonPathParser(tokens);
        ParseTree tree = parser.jsonPath();
        JsonPath jsonPath = new JsonPath();
        jsonPath.visit(tree);



        JsonElement json = new Gson().fromJson("{\n" +
                "    \"author\": {\n" +
                "        \"positionId\": \"123456789\",\n" +
                "        \"employeeNumber\": \"12345\",\n" +
                "        \"holding\": [\n" +
                "            {\n" +
                "                \"epkId\": \"88888888888888888888888\",\n" +
                "                \"crmId\": \"2222\",\n" +
                "                \"client\": [\n" +
                "                    {\n" +
                "                        \"epkId\": \"1111111111111111111\",\n" +
                "                        \"crmId\": \"1-11FUEJ06\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"epkId\": \"2222222222222222222\",\n" +
                "                        \"crmId\": \"1-11FUEJ06\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"epkId\": \"4444444444444444444\",\n" +
                "                        \"crmId\": \"1-11FUEJ06\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"epkId\": \"6666666666666666666\",\n" +
                "                        \"crmId\": \"1-11FUEJ06\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"epkId\": \"7777777777777777777\",\n" +
                "                        \"crmId\": \"1-11FUEJ06\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"epkId\": \"99999999999999999999999\",\n" +
                "                \"crmId\": \"2222\",\n" +
                "                \"client\": [\n" +
                "                    {\n" +
                "                        \"epkId\": \"1111111111111111111\",\n" +
                "                        \"crmId\": \"1-11FUEJ06\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"epkId\": \"3333333333333333333\",\n" +
                "                        \"crmId\": \"1-11FUEJ06\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"epkId\": \"4444444444444444444\",\n" +
                "                        \"crmId\": \"1-11FUEJ06\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"epkId\": \"5555555555555555555\",\n" +
                "                        \"crmId\": \"1-11FUEJ06\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"epkId\": \"6666666666666666666\",\n" +
                "                        \"crmId\": \"1-11FUEJ06\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}", JsonElement.class);

        System.out.println(jsonPath.getValue(json));
    }
}