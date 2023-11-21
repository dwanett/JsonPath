package jsonPath;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class Main {

    public static void main(String[] args) {
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
                "                        \"crmId\": \"12345\"\n" +
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
                "                        \"crmId\": \"12345\"\n" +
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

        System.out.println(JsonPath.getValue(json, "author.holding[(client[(crmId == ../../employeeNumber)])].client.epkId"));
    }
}