package jsonPath;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestWork {

    private static final JsonElement json = new Gson().fromJson("{\n" +
            "\"success\": true,\n" +
            "\"body\": {\n" +
            "\"E2ELeads\": [{\n" +
            "\"offerId\": \"2222222\",\n" +
            "\"leadId\": \"2222222\",\n" +
            "\"version\": 1,\n" +
            "\"e2eProductId\": \"024\",\n" +
            "\"crmProductId\": \"1-15UG044Z\",\n" +
            "\"volumePot\": 123,\n" +
            "\"chodPot\": 321,\n" +
            "\"createDate\": \"2023-06-16T11:15:08.684Z\",\n" +
            "\"status\": \"POT_FOR_SALE\",\n" +
            "\"needVerifyRefusal\": false,\n" +
            "\"arrayPrimitive\": [\"1111\", \"2222\"],\n" +
            "\"arrayTest\": [],\n" +
            "\"author\": {\n" +
            "\"positionId\": \"123456789\",\n" +
            "\"employeeNumber\": \"343653\",\n" +
            "\"holding\": [{\n" +
            "\"epkId\": \"11111111111111111111111\",\n" +
            "\"crmId\": \"9999\",\n" +
            "\"client\": [{\n" +
            "\"epkId\": \"1111111111111111111\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"2222222222222222222\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"4444444444444444444\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"6666666666666666666\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"7777777777777777777\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}\n" +
            "]\n" +
            "}, {\n" +
            "\"epkId\": \"22222222222222222222222\",\n" +
            "\"crmId\": \"8888\",\n" +
            "\"client\": [{\n" +
            "\"epkId\": \"1111111111111111111\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"2222222222222222222\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"4444444444444444444\",\n" +
            "\"crmId\": \"AAAAAAA\"\n" +
            "}, {\n" +
            "\"epkId\": \"5555555555555555555\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"6666666666666666666\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}\n" +
            "]\n" +
            "}, {\n" +
            "\"epkId\": \"333333333333333333333333\",\n" +
            "\"crmId\": \"7777\",\n" +
            "\"client\": [{\n" +
            "\"epkId\": \"2222222222222222222\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"4444444444444444444\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"5555555555555555555\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"6666666666666666666\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"7777777777777777777\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}\n" +
            "]\n" +
            "}\n" +
            "]\n" +
            "}\n" +
            "\n" +
            "}, {\n" +
            "\"offerId\": \"1111111\",\n" +
            "\"leadId\": \"1111111\",\n" +
            "\"VBR\": \"AAAAA\",\n" +
            "\"version\": 1,\n" +
            "\"e2eProductId\": \"1012\",\n" +
            "\"crmProductId\": \"1-2LU9TZF\",\n" +
            "\"volumePot\": 11,\n" +
            "\"chodPot\": 11,\n" +
            "\"createDate\": \"2023-06-01T10:42:17.919Z\",\n" +
            "\"status\": \"POT_FOR_SALE\",\n" +
            "\"needVerifyRefusal\": false,\n" +
            "\"arrayPrimitive\": [\"3333\", \"4444\"],\n" +
            "\"arrayTest\": [{\n" +
            "\"ad\": \"a\",\n" +
            "\"epkId\": \"1111111111111111111\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"2222222222222222222\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"5555555555555555555\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"6666666666666666666\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"7777777777777777777\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}\n" +
            "],\n" +
            "\"author\": {\n" +
            "\"positionId\": \"123456789\",\n" +
            "\"employeeNumber\": \"343653\",\n" +
            "\"holding\": [{\n" +
            "\"epkId\": \"44444444444444444444444\",\n" +
            "\"crmId\": \"6666\",\n" +
            "\"client\": [{\n" +
            "\"epkId\": \"1111111111111111111\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"2222222222222222222\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"55555555555555555557\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"6666666666666666666\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"7777777777777777777\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}\n" +
            "]\n" +
            "}, {\n" +
            "\"epkId\": \"55555555555555555555555\",\n" +
            "\"crmId\": \"5555\",\n" +
            "\"client\": [{\n" +
            "\"epkId\": \"1111111111111111111\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"2222222222222222222\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"4444444444444444444\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"5555555555555555555\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"7777777777777777777\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}\n" +
            "]\n" +
            "}, {\n" +
            "\"epkId\": \"66666666666666666666666\",\n" +
            "\"crmId\": \"4444\",\n" +
            "\"client\": [{\n" +
            "\"epkId\": \"1111111111111111111\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"2222222222222222222\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"4444444444444444444\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"5555555555555555555\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"6666666666666666666\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}\n" +
            "]\n" +
            "}\n" +
            "]\n" +
            "}\n" +
            "}, {\n" +
            "\"offerId\": \"3333333\",\n" +
            "\"leadId\": \"4444444\",\n" +
            "\"version\": 2,\n" +
            "\"e2eProductId\": \"1009\",\n" +
            "\"crmProductId\": \"1-XNQ72X3\",\n" +
            "\"volumePot\": 33,\n" +
            "\"chodPot\": null,\n" +
            "\"createDate\": \"2023-06-01T10:53:30.952Z\",\n" +
            "\"status\": \"POT_FOR_SALE\",\n" +
            "\"needVerifyRefusal\": false,\n" +
            "\"arrayPrimitive\": [\"5555\", \"6666\"],\n" +
            "\"author\": {\n" +
            "\"positionId\": \"123456789\",\n" +
            "\"employeeNumber\": \"12345\",\n" +
            "\"holding\": [{\n" +
            "\"epkId\": \"77777777777777777777777\",\n" +
            "\"crmId\": \"3333\",\n" +
            "\"client\": [{\n" +
            "\"epkId\": \"2222222222222222222\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"4444444444444444444\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"5555555555555555555\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"6666666666666666666\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"7777777777777777777\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}\n" +
            "]\n" +
            "}, {\n" +
            "\"epkId\": \"88888888888888888888888\",\n" +
            "\"crmId\": \"2222\",\n" +
            "\"client\": [{\n" +
            "\"epkId\": \"1111111111111111111\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"2222222222222222222\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"4444444444444444444\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"6666666666666666666\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"7777777777777777777\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}\n" +
            "]\n" +
            "}, {\n" +
            "\"epkId\": \"99999999999999999999999\",\n" +
            "\"crmId\": \"1111\",\n" +
            "\"client\": [{\n" +
            "\"epkId\": \"1111111111111111111\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"3333333333333333333\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"4444444444444444444\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"5555555555555555555\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}, {\n" +
            "\"epkId\": \"6666666666666666666\",\n" +
            "\"crmId\": \"1-11FUEJ06\"\n" +
            "}\n" +
            "]\n" +
            "}\n" +
            "]\n" +
            "}\n" +
            "}\n" +
            "]\n" +
            "}\n" +
            "}", JsonElement.class);

    @Test
    public void WorkTest() {
        SoftAssert softAssert = new SoftAssert();


        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[~].author.holding[~].client[~].epkId"), "[[[\"1111111111111111111\",\"2222222222222222222\",\"4444444444444444444\",\"6666666666666666666\",\"7777777777777777777\"],[\"1111111111111111111\",\"2222222222222222222\",\"4444444444444444444\",\"5555555555555555555\",\"6666666666666666666\"],[\"2222222222222222222\",\"4444444444444444444\",\"5555555555555555555\",\"6666666666666666666\",\"7777777777777777777\"]],[[\"1111111111111111111\",\"2222222222222222222\",\"55555555555555555557\",\"6666666666666666666\",\"7777777777777777777\"],[\"1111111111111111111\",\"2222222222222222222\",\"4444444444444444444\",\"5555555555555555555\",\"7777777777777777777\"],[\"1111111111111111111\",\"2222222222222222222\",\"4444444444444444444\",\"5555555555555555555\",\"6666666666666666666\"]],[[\"2222222222222222222\",\"4444444444444444444\",\"5555555555555555555\",\"6666666666666666666\",\"7777777777777777777\"],[\"1111111111111111111\",\"2222222222222222222\",\"4444444444444444444\",\"6666666666666666666\",\"7777777777777777777\"],[\"1111111111111111111\",\"3333333333333333333\",\"4444444444444444444\",\"5555555555555555555\",\"6666666666666666666\"]]]", "body.E2ELeads[~].author.holding[~].client[~].epkId");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(author.holding[(client[(epkId == \"55555555555555555557\")])])].offerId"), "1111111", "body.E2ELeads[(author.holding[(client[(epkId == \"55555555555555555557\")])])].offerId ");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(version == \"1\" && author.holding[(client[(epkId == \"1111111111111111111\")])].crmId == \"6666\")].offerId"), "1111111", "body.E2ELeads[(version == \"1\" && author.holding[(client[(epkId == \"1111111111111111111\")])].crmId == \"6666\")].offerId ");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[({offerId == \"3333333\" <> offerId == \"1111111\"} && {version == 1 && e2eProductId == \"1012\"})].offerId"), "1111111", "body.E2ELeads[({offerId == \"3333333\" <> offerId == \"1111111\"} && {version == 1 && e2eProductId == \"1012\"})].offerId ");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[({offerId == \"3333333\" <> offerId == \"1111111\"} && {{version == 2 && e2eProductId == \"1009\"} <> {version == 1 && e2eProductId == \"1012\"}})].offerId"), "1111111", "body.E2ELeads[({offerId == \"3333333\" <> offerId == \"1111111\"} && {{version == 2 && e2eProductId == \"1009\"} <> {version == 1 && e2eProductId == \"1012\"}})].offerId ");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[({offerId == \"3333333\" <> offerId == \"1111111\"} && {{version == 2 && e2eProductId == \"1009\"} <> {version == 1 && e2eProductId == \"1012\"}})][1].offerId"), "3333333", "body.E2ELeads[({offerId == \"3333333\" <> offerId == \"1111111\"} && {{version == 2 && e2eProductId == \"1009\"} <> {version == 1 && e2eProductId == \"1012\"}})][1].offerId");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(author.holding[(client[(epkId == \"1111111111111111111\")])].crmId == \"6666\" <> author.holding[(client[(epkId == \"2222222222222222222\")])].crmId == \"9999\")].offerId"), "2222222", "body.E2ELeads[(author.holding[(client[(epkId == \"1111111111111111111\")])].crmId == \"6666\" <> author.holding[(client[(epkId == \"2222222222222222222\")])].crmId == \"9999\")].offerId ");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(author.holding[(client[(epkId == \"1111111111111111111\")])].crmId == \"6666\" <> author.holding[(client[(epkId == \"2222222222222222222\")])].crmId == \"9999\")][1].offerId"), "1111111", "body.E2ELeads[(author.holding[(client[(epkId == \"1111111111111111111\")])].crmId == \"6666\" <> author.holding[(client[(epkId == \"2222222222222222222\")])].crmId == \"9999\")][1].offerId");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(author.holding[(client[(epkId == \"1111111111111111111\")])].crmId == \"6666\" <> author.holding[(client[(epkId == \"2222222222222222222\")])].crmId == \"9999\")][~].offerId"), "[\"2222222\",\"1111111\"]", "body.E2ELeads[(author.holding[(client[(epkId == \"1111111111111111111\")])].crmId == \"6666\" <> author.holding[(client[(epkId == \"2222222222222222222\")])].crmId == \"9999\")][~].offerId");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(offerId == \"1111111\")].author.holding[(epkId == \"66666666666666666666666\")].crmId"), "4444", "body.E2ELeads[(offerId == \"1111111\")].author.holding[(epkId == \"66666666666666666666666\")].crmId");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(author.holding[allMatch(client[(crmId == \"1-11FUEJ06\")])])].offerId"), "2222222", "body.E2ELeads[(author.holding[*(client[(crmId == \"1-11FUEJ06\")])])].offerId ");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(author.holding[allMatch(client[(crmId == \"1-11FUEJ06\")])])][1].offerId"), "1111111", "body.E2ELeads[(author.holding[*(client[(crmId == \"1-11FUEJ06\")])])][1].offerId");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(author.holding[(client[(crmId == \"1-11FUEJ06\")])])].offerId"), "2222222", "body.E2ELeads[(author.holding[(client[(crmId == \"1-11FUEJ06\")])])].offerId");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(author.holding[(client[(crmId == \"1-11FUEJ06\")])])][1].offerId "), "1111111", "body.E2ELeads[(author.holding[(client[(crmId == \"1-11FUEJ06\")])])][1].offerId ");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[2].leadId"), "4444444", "body.E2ELeads[2].leadId");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(version == 1 && e2eProductId == \"024\" <> e2eProductId == \"1012\" && crmProductId == \"1-2LU9TZF\")][1].leadId"), "1111111", "body.E2ELeads[(version == 1 && e2eProductId == \"024\" <> e2eProductId == \"1012\" && crmProductId == \"1-2LU9TZF\")][1].leadId");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(version == 1 && e2eProductId == \"024\" <> e2eProductId == \"1012\" && crmProductId == \"1-2LU9TZF\")][~].author"), "[{\"positionId\":\"123456789\",\"employeeNumber\":\"343653\",\"holding\":[{\"epkId\":\"11111111111111111111111\",\"crmId\":\"9999\",\"client\":[{\"epkId\":\"1111111111111111111\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"4444444444444444444\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"6666666666666666666\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"7777777777777777777\",\"crmId\":\"1-11FUEJ06\"}]},{\"epkId\":\"22222222222222222222222\",\"crmId\":\"8888\",\"client\":[{\"epkId\":\"1111111111111111111\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"4444444444444444444\",\"crmId\":\"AAAAAAA\"},{\"epkId\":\"5555555555555555555\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"6666666666666666666\",\"crmId\":\"1-11FUEJ06\"}]},{\"epkId\":\"333333333333333333333333\",\"crmId\":\"7777\",\"client\":[{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"4444444444444444444\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"5555555555555555555\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"6666666666666666666\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"7777777777777777777\",\"crmId\":\"1-11FUEJ06\"}]}]},{\"positionId\":\"123456789\",\"employeeNumber\":\"343653\",\"holding\":[{\"epkId\":\"44444444444444444444444\",\"crmId\":\"6666\",\"client\":[{\"epkId\":\"1111111111111111111\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"55555555555555555557\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"6666666666666666666\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"7777777777777777777\",\"crmId\":\"1-11FUEJ06\"}]},{\"epkId\":\"55555555555555555555555\",\"crmId\":\"5555\",\"client\":[{\"epkId\":\"1111111111111111111\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"4444444444444444444\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"5555555555555555555\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"7777777777777777777\",\"crmId\":\"1-11FUEJ06\"}]},{\"epkId\":\"66666666666666666666666\",\"crmId\":\"4444\",\"client\":[{\"epkId\":\"1111111111111111111\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"4444444444444444444\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"5555555555555555555\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"6666666666666666666\",\"crmId\":\"1-11FUEJ06\"}]}]}]", "body.E2ELeads[(version == 1 && e2eProductId == \"024\" <> e2eProductId == \"1012\" && crmProductId == \"1-2LU9TZF\")][~].author");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(version == 1 && e2eProductId == \"024\" <> e2eProductId == \"1012\" && crmProductId == \"1-2LU9TZF\")].offerId"), "2222222", "body.E2ELeads[(version == 1 && e2eProductId == \"024\" <> e2eProductId == \"1012\" && crmProductId == \"1-2LU9TZF\")].offerId");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(version == 1 && {e2eProductId == \"024\" <> e2eProductId == \"1012\"} && crmProductId == \"1-2LU9TZF\")].offerId"), "1111111", "body.E2ELeads[(version == 1 && {e2eProductId == \"024\" <> e2eProductId == \"1012\"} && crmProductId == \"1-2LU9TZF\")].offerId");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[nonMatch(version == 2 && e2eProductId == \"024\")].offerId "), "2222222", "body.E2ELeads[nonMatch(version == 2 && e2eProductId == \"024\")].offerId ");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(VBR)].offerId"), "1111111", "body.E2ELeads[(VBR)].offerId");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[nonMatch(version == 2 && e2eProductId == \"024\")].arrayPrimitive[1] "), "2222", "body.E2ELeads[nonMatch(version == 2 && e2eProductId == \"024\")].arrayPrimitive[1] ");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[nonMatch(version == 2 && e2eProductId == \"024\")].arrayPrimitive[~] "), "[\"1111\",\"2222\"]", "body.E2ELeads[nonMatch(version == 2 && e2eProductId == \"024\")].arrayPrimitive[~] ");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(VBR)].arrayPrimitive[0]"), "3333", "body.E2ELeads[(VBR)].arrayPrimitive[0]");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(offerId == reg(\"[3]{7}\") && leadId == reg(\"[4]{7}\"))].crmProductId "), "1-XNQ72X3", "body.E2ELeads[(offerId == reg(\"[3]{7}\") && leadId == reg(\"[4]{7}\"))].crmProductId ");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(leadId == \"4444444\")].author "), "{\"positionId\":\"123456789\",\"employeeNumber\":\"12345\",\"holding\":[{\"epkId\":\"77777777777777777777777\",\"crmId\":\"3333\",\"client\":[{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"4444444444444444444\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"5555555555555555555\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"6666666666666666666\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"7777777777777777777\",\"crmId\":\"1-11FUEJ06\"}]},{\"epkId\":\"88888888888888888888888\",\"crmId\":\"2222\",\"client\":[{\"epkId\":\"1111111111111111111\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"4444444444444444444\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"6666666666666666666\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"7777777777777777777\",\"crmId\":\"1-11FUEJ06\"}]},{\"epkId\":\"99999999999999999999999\",\"crmId\":\"1111\",\"client\":[{\"epkId\":\"1111111111111111111\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"3333333333333333333\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"4444444444444444444\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"5555555555555555555\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"6666666666666666666\",\"crmId\":\"1-11FUEJ06\"}]}]}", "body.E2ELeads[(leadId == \"4444444\")].author ");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(leadId == \"4444444\")].arrayPrimitive"), "[\"5555\",\"6666\"]", "body.E2ELeads[(leadId == \"4444444\")].arrayPrimitive ");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(arrayTest[(ad == \"a\")])]"), "[{\"offerId\":\"1111111\",\"leadId\":\"1111111\",\"VBR\":\"AAAAA\",\"version\":1,\"e2eProductId\":\"1012\",\"crmProductId\":\"1-2LU9TZF\",\"volumePot\":11,\"chodPot\":11,\"createDate\":\"2023-06-01T10:42:17.919Z\",\"status\":\"POT_FOR_SALE\",\"needVerifyRefusal\":false,\"arrayPrimitive\":[\"3333\",\"4444\"],\"arrayTest\":[{\"ad\":\"a\",\"epkId\":\"1111111111111111111\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"5555555555555555555\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"6666666666666666666\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"7777777777777777777\",\"crmId\":\"1-11FUEJ06\"}],\"author\":{\"positionId\":\"123456789\",\"employeeNumber\":\"343653\",\"holding\":[{\"epkId\":\"44444444444444444444444\",\"crmId\":\"6666\",\"client\":[{\"epkId\":\"1111111111111111111\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"55555555555555555557\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"6666666666666666666\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"7777777777777777777\",\"crmId\":\"1-11FUEJ06\"}]},{\"epkId\":\"55555555555555555555555\",\"crmId\":\"5555\",\"client\":[{\"epkId\":\"1111111111111111111\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"4444444444444444444\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"5555555555555555555\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"7777777777777777777\",\"crmId\":\"1-11FUEJ06\"}]},{\"epkId\":\"66666666666666666666666\",\"crmId\":\"4444\",\"client\":[{\"epkId\":\"1111111111111111111\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"4444444444444444444\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"5555555555555555555\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"6666666666666666666\",\"crmId\":\"1-11FUEJ06\"}]}]}}]", "body.E2ELeads[(arrayTest[(ad == \"a\")])] ");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(arrayTest[(ad)])]"), "[{\"offerId\":\"1111111\",\"leadId\":\"1111111\",\"VBR\":\"AAAAA\",\"version\":1,\"e2eProductId\":\"1012\",\"crmProductId\":\"1-2LU9TZF\",\"volumePot\":11,\"chodPot\":11,\"createDate\":\"2023-06-01T10:42:17.919Z\",\"status\":\"POT_FOR_SALE\",\"needVerifyRefusal\":false,\"arrayPrimitive\":[\"3333\",\"4444\"],\"arrayTest\":[{\"ad\":\"a\",\"epkId\":\"1111111111111111111\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"5555555555555555555\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"6666666666666666666\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"7777777777777777777\",\"crmId\":\"1-11FUEJ06\"}],\"author\":{\"positionId\":\"123456789\",\"employeeNumber\":\"343653\",\"holding\":[{\"epkId\":\"44444444444444444444444\",\"crmId\":\"6666\",\"client\":[{\"epkId\":\"1111111111111111111\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"55555555555555555557\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"6666666666666666666\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"7777777777777777777\",\"crmId\":\"1-11FUEJ06\"}]},{\"epkId\":\"55555555555555555555555\",\"crmId\":\"5555\",\"client\":[{\"epkId\":\"1111111111111111111\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"4444444444444444444\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"5555555555555555555\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"7777777777777777777\",\"crmId\":\"1-11FUEJ06\"}]},{\"epkId\":\"66666666666666666666666\",\"crmId\":\"4444\",\"client\":[{\"epkId\":\"1111111111111111111\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"2222222222222222222\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"4444444444444444444\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"5555555555555555555\",\"crmId\":\"1-11FUEJ06\"},{\"epkId\":\"6666666666666666666\",\"crmId\":\"1-11FUEJ06\"}]}]}}]", "body.E2ELeads[(arrayTest[(ad)])]");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads.author.holding[(epkId == \"11111111111111111111111\")].crmId"), "9999", "body.E2ELeads.author.holding[(epkId == \"11111111111111111111111\")].crmId");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(offerId != 3333333 && offerId != 2222222)].offerId"), "1111111", "body.E2ELeads[(offerId != 3333333 && offerId != 2222222)].offerId ");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(offerId == ../E2ELeads[1].offerId)].offerId"), "1111111", "body.E2ELeads[(offerId == ../E2ELeads[1].offerId)].offerId");
        softAssert.assertEquals(JsonPath.getValue(json, "body.E2ELeads[(chodPot == null)].offerId"), "3333333", "body.E2ELeads[(chodPot == null)].offerId");

        softAssert.assertAll();
    }

}
