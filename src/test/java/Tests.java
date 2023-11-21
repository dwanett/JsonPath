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
    @Test
    public void PathTest() {
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

        softAssert.assertEquals(JsonPath.getValue(json, "client"), "[{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"4444444444444444444\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"5555555555555555555\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"6666666666666666666\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"7777777777777777777\",\"crmId\":\"1-11FUEJ06\"}]", "client");
        softAssert.assertEquals(JsonPath.getValue(json, "client[1]"), "{\"epkId\":\"4444444444444444444\",\"crmId\":\"1-11FUEJ06\"}", "client[1]");
        softAssert.assertEquals(JsonPath.getValue(json, "client[~]"), "[{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"4444444444444444444\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"5555555555555555555\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"6666666666666666666\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"7777777777777777777\",\"crmId\":\"1-11FUEJ06\"}]", "client[~]");

        softAssert.assertEquals(JsonPath.getValue(json, "client.epkId"), "2222222222222222222",  "client.epkId");
        softAssert.assertEquals(JsonPath.getValue(json, "client[1].epkId"), "4444444444444444444", "client[1].epkId");
        softAssert.assertEquals(JsonPath.getValue(json, "client[~].epkId"), "[\"2222222222222222222\",\"4444444444444444444\",\"5555555555555555555\",\"6666666666666666666\",\"7777777777777777777\"]", "client[~].epkId");

        softAssert.assertAll();
    }

    @Test
    public void ConditionTest() {
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

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(JsonPath.getValue(json, "author.holding[(epkId == \"88888888888888888888888\" || epkId == \"99999999999999999999999\")][~].epkId"), "[\"88888888888888888888888\",\"99999999999999999999999\"]");
        softAssert.assertEquals(JsonPath.getValue(json, "author.holding[({epkId == \"88888888888888888888888\" || epkId == \"99999999999999999999999\"} && crmId == 2222)][1].epkId"), "99999999999999999999999");
        softAssert.assertEquals(JsonPath.getValue(json, "author.holding[(client[1].epkId != \"3333333333333333333\")].epkId"), "88888888888888888888888");
        softAssert.assertEquals(JsonPath.getValue(json, "author.holding[(client[(epkId == \"3333333333333333333\")].epkId == \"3333333333333333333\")].epkId"), "99999999999999999999999");
        softAssert.assertEquals(JsonPath.getValue(json, "author.holding[(epkId == \"88888888888888888888888\")].epkId"), "88888888888888888888888");
        softAssert.assertAll();
    }

    @Test
    public void FunctionTest() {
        JsonElement json = new Gson().fromJson("{\n" +
                "    \"author\": {\n" +
                "        \"positionId\": \"123456789\",\n" +
                "        \"employeeNumber\": \"12345\",\n" +
                "        \"holding\": [\n" +
                "            {\n" +
                "                \"epkId\": \"99999999999999999999999\",\n" +
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
                "                \"epkId\": \"88888888888888888888888\",\n" +
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

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(JsonPath.getValue(json, "author.holding[~].epkId.sort()"), "[\"88888888888888888888888\",\"99999999999999999999999\"]");
        softAssert.assertEquals(JsonPath.getValue(json, "author.holding[~].epkId.size()"), "2");
        softAssert.assertEquals(JsonPath.getValue(json, "author.holding.sort()"), "[{\"epkId\":\"88888888888888888888888\",\"crmId\":\"2222\",\"client\":[{\"epkId\":\"1111111111111111111\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"3333333333333333333\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"4444444444444444444\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"5555555555555555555\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"6666666666666666666\",\"crmId\":\"1-11FUEJ06\"}]},{\"epkId\":\"99999999999999999999999\",\"crmId\":\"2222\",\"client\":[{\"epkId\":\"1111111111111111111\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"4444444444444444444\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"6666666666666666666\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"7777777777777777777\",\"crmId\":\"1-11FUEJ06\"}]}]");
        softAssert.assertEquals(JsonPath.getValue(json, "author.holding.size()"), "2");
        softAssert.assertEquals(JsonPath.getValue(json, "author.holding[(epkId == contains(\"9\"))].epkId"), "99999999999999999999999");
        softAssert.assertEquals(JsonPath.getValue(json, "author.holding[(epkId == reg(\"[8]{23}\"))].epkId"), "88888888888888888888888");
        softAssert.assertAll();
    }
}