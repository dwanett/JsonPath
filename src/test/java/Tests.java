import antlr.JsonPathLexer;
import antlr.JsonPathParser;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import jsonPath.JsonPath;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tests {

    public JsonPath jsonPathPars(String jsonPathStr) {
        JsonPathLexer lexer = new JsonPathLexer(CharStreams.fromString(jsonPathStr));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JsonPathParser parser = new JsonPathParser(tokens);
        ParseTree tree = parser.jsonPath();
        JsonPath jsonPath = new JsonPath();
        jsonPath.visit(tree);
        return jsonPath;
    }

    @Test
    public void FunctionTest() {
        JsonElement json = new Gson().fromJson("{\n" +
                "    \"epkId\": \"333333333333333333333333\",\n" +
                "    \"crmId\": \"7777\",\n" +
                "    \"client\": [\n" +
                "        {\n" +
                "            \"epkId\": \"2222222222222222222\",\n" +
                "            \"crmId\": \"1-11FUEJ06\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"epkId\": \"4444444444444444444\",\n" +
                "            \"crmId\": \"1-11FUEJ06\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"epkId\": \"5555555555555555555\",\n" +
                "            \"crmId\": \"1-11FUEJ06\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"epkId\": \"6666666666666666666\",\n" +
                "            \"crmId\": \"1-11FUEJ06\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"epkId\": \"7777777777777777777\",\n" +
                "            \"crmId\": \"1-11FUEJ06\"\n" +
                "        }\n" +
                "    ]\n" +
                "}", JsonElement.class);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(jsonPathPars("client").getValue(json), "{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"}", "client");
        softAssert.assertEquals(jsonPathPars("client[1]").getValue(json), "{\"epkId\":\"4444444444444444444\",\"crmId\":\"1-11FUEJ06\"}", "client[1]");
        softAssert.assertEquals(jsonPathPars("client[~]").getValue(json), "[{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"4444444444444444444\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"5555555555555555555\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"6666666666666666666\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"7777777777777777777\",\"crmId\":\"1-11FUEJ06\"}]", "client[~]");

        softAssert.assertEquals(jsonPathPars("client.epkId").getValue(json), "2222222222222222222",  "client.epkId");
        softAssert.assertEquals(jsonPathPars("client[1].epkId").getValue(json), "4444444444444444444", "client[1].epkId");
        softAssert.assertEquals(jsonPathPars("client[~].epkId").getValue(json), "[\"2222222222222222222\",\"4444444444444444444\",\"5555555555555555555\",\"6666666666666666666\",\"7777777777777777777\"]", "client[~].epkId");

        softAssert.assertAll();
    }
}

