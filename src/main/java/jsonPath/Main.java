package jsonPath;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        JsonElement json = new Gson().fromJson("{\n" +
                "    \"success\": true,\n" +
                "    \"body\": {\n" +
                "        \"E2ELeads\": [{\n" +
                "                \"offerId\": \"2222222\",\n" +
                "                \"leadId\": \"2222222\",\n" +
                "                \"version\": 1,\n" +
                "                \"e2eProductId\": \"024\",\n" +
                "                \"crmProductId\": \"1-15UG044Z\",\n" +
                "                \"volumePot\": 123,\n" +
                "                \"chodPot\": 321,\n" +
                "                \"createDate\": \"2023-06-16T11:15:08.684Z\",\n" +
                "                \"status\": \"POT_FOR_SALE\",\n" +
                "                \"needVerifyRefusal\": false,\n" +
                "                \"arrayPrimitive\": [\"1111\", \"2222\"],\n" +
                "                \"arrayTest\": [],\n" +
                "                \"value\": [\"VRKLDS:ClientRequestCreating;Оформление заявки;true;10\",\"VRKLDS:DealStructuring;Структурирование;true;20\",\"VRKLDS:CollectionAnalysisDocuments;Сбор и анализ документов;true;50\",\"VRKLDS:CreatingCOD;Подготовка КОД;true;40\",\"VRKLDS:SigningCOD;Подписание КОД;true;60\",\"VRKLDS:DealDecisionMaking01;Принятие решения;true;30\",\"VRKLDS:AutoRegistrationCOD;Регистрация договора;true;70\",\"VRKLDS:RejectionDeal;Отказ по сделке;true;80\",\"OGRNT:ClientRequestFiling;Оформление заявки;true;10\",\"OGRNT:DealStructuring;Структурирование;true;20\",\"OGRNT:CreateLimit;Структурирование;true;30\",\"OGRNT:FinalingProductDocuments;Сбор и анализ документов;true;40\",\"OGRNT:CollectonAnalysisDocuments;Сбор и анализ документов;true;50\",\"OGRNT:CreateCOD;Подготовка КОД;true;60\",\"OGRNT:SignCodClient;Подписание КОД;true;70\",\"OGRNT:AutoRegistrationCOD;Регистрация договора;true;80\",\"OGRNT:RejectDeal;Отказ по сделке;true;90\",\"OGRNT:RejectDeal;Завершение сделки;true;100\",\"FZHN:ClientRequestFiling;Оформление заявки;true;10\",\"FZHN:DealStructuring;Структурирование;true;20\",\"FZHN:LKSE_Express;Подготовка заключений;true;30\",\"FZHN:Model_Calculate;Формирование CF-модели и TS;true;40\",\"FZHN:Risk_Approval;Принятие решения;true;50\",\"FZHN:Document_Collecting;Сбор и анализ документов;true;60\",\"FZHN:TS_Sign;Подписание TS;true;70\",\"FZHN:Dept_Approval;Детальный анализ;true;80\",\"FZHN:Create_KOD;Подготовка КОД;true;90\"],\n" +
                "                \"author\": {\n" +
                "                    \"positionId\": \"123456789\",\n" +
                "                    \"employeeNumber\": \"343653\",\n" +
                "                    \"holding\": [{\n" +
                "                            \"epkId\": \"11111111111111111111111\",\n" +
                "                            \"crmId\": \"9999\",\n" +
                "                            \"client\": [{\n" +
                "                                    \"epkId\": \"1111111111111111111\",\n" +
                "                                    \"crmId\": \"1-11FUEJ06\"\n" +
                "                                }, {\n" +
                "                                    \"epkId\": \"2222222222222222222\",\n" +
                "                                    \"crmId\": \"1-11FUEJ06\"\n" +
                "                                }, {\n" +
                "                                    \"epkId\": \"4444444444444444444\",\n" +
                "                                    \"crmId\": \"1-11FUEJ06\"\n" +
                "                                }, {\n" +
                "                                    \"epkId\": \"6666666666666666666\",\n" +
                "                                    \"crmId\": \"1-11FUEJ06\"\n" +
                "                                }, {\n" +
                "                                    \"epkId\": \"7777777777777777777\",\n" +
                "                                    \"crmId\": \"1-11FUEJ06\"\n" +
                "                                }\n" +
                "                            ]\n" +
                "                        }, {\n" +
                "                            \"epkId\": \"22222222222222222222222\",\n" +
                "                            \"crmId\": \"8888\",\n" +
                "                            \"client\": [{\n" +
                "                                    \"epkId\": \"1111111111111111111\",\n" +
                "                                    \"crmId\": \"1-11FUEJ06\"\n" +
                "                                }, {\n" +
                "                                    \"epkId\": \"2222222222222222222\",\n" +
                "                                    \"crmId\": \"1-11FUEJ06\"\n" +
                "                                }, {\n" +
                "                                    \"epkId\": \"4444444444444444444\",\n" +
                "                                    \"crmId\": \"AAAAAAA\"\n" +
                "                                }, {\n" +
                "                                    \"epkId\": \"5555555555555555555\",\n" +
                "                                    \"crmId\": \"1-11FUEJ06\"\n" +
                "                                }, {\n" +
                "                                    \"epkId\": \"6666666666666666666\",\n" +
                "                                    \"crmId\": \"1-11FUEJ06\"\n" +
                "                                }\n" +
                "                            ]\n" +
                "                        }, {\n" +
                "                            \"epkId\": \"333333333333333333333333\",\n" +
                "                            \"crmId\": \"7777\",\n" +
                "                            \"client\": [{\n" +
                "                                    \"epkId\": \"2222222222222222222\",\n" +
                "                                    \"crmId\": \"1-11FUEJ06\"\n" +
                "                                }, {\n" +
                "                                    \"epkId\": \"4444444444444444444\",\n" +
                "                                    \"crmId\": \"1-11FUEJ068\"\n" +
                "                                }, {\n" +
                "                                    \"epkId\": \"5555555555555555555\",\n" +
                "                                    \"crmId\": \"1-11FUEJ068\"\n" +
                "                                }, {\n" +
                "                                    \"epkId\": \"6666666666666666666\",\n" +
                "                                    \"crmId\": \"1-11FUEJ068\"\n" +
                "                                }, {\n" +
                "                                    \"epkId\": \"7777777777777777777\",\n" +
                "                                    \"crmId\": \"1-11FUEJ068\"\n" +
                "                                }\n" +
                "                            ]\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}", JsonElement.class);

        System.out.println(JsonPath.getValue(json, "body.E2ELeads[(asdad == null)]"));
        //System.out.println(JsonPath.getValue(json, "library.books[(publisher == contains(\"Russian\"))]"));

        //regenTests(json);
    }

    private static void regenTests (JsonElement json) {
        Map<String, List<String>> tests = new HashMap<>();

        List<String> pathTest = new ArrayList<>();
        pathTest.add("library");
        pathTest.add("library.location");
        pathTest.add("library.books");
        pathTest.add("library.books[1]");
        pathTest.add("library.books[~].title");
        pathTest.add("library.books.title");
        tests.put("PathTest", pathTest);

        List<String> conditionTest = new ArrayList<>();
        conditionTest.add("library.books[(publication_year < 1868)].details.available_copies");
        conditionTest.add("library.books[(publication_year == 1949 <> publication_year == 1866)][~].title");
        conditionTest.add("library.books[(details.pages < 500)][~].details.pages");
        conditionTest.add("library.books[(publisher == \"The Russian Messenger\")].title");
        conditionTest.add("library.books[(publisher == \"The Russian Messenger\")][0].title");
        conditionTest.add("library.books[(publisher == \"The Russian Messenger\")][1].title");
        conditionTest.add("library.books[({author == \"Leo Tolstoy\" <> author == \"Harper Lee\"} && details.pages < 500)][~].details.pages");
        conditionTest.add("library.books[(reviews[(user == \"Mary\")])]");
        conditionTest.add("library.books[(reviews)]");
        conditionTest.add("library.books[(author == \"George Orwell\" && title == \"1984\" <> title == \"War and Peace\" && publication_year == 1869)][~].title");
        conditionTest.add("library.books[(author == \"George Orwell\" && {title == \"1984\" <> title == \"War and Peace\"} && publication_year == 1869)][~].title");
        conditionTest.add("library.books[(reviews[nonMatch(rating == 6)])][~].title");
        conditionTest.add("library.books[(reviews[nonMatch(rating == 5)])][~].title");
        conditionTest.add("library.books[(reviews[nonMatch(rating == 4)])][~].title");
        conditionTest.add("library.books[(reviews[allMatch(rating == 4)])][~].title");
        conditionTest.add("library.books[(reviews[allMatch(rating == 5)])][~].title");
        conditionTest.add("library.books[(reviews[(awards[allMatch(prize == 1500)])])]");
        tests.put("ConditionTest", conditionTest);

        List<String> functionTest = new ArrayList<>();
        functionTest.add("library.books[~].details.pages.sort()");
        functionTest.add("library.books[~].details.pages.size()");
        functionTest.add("library.books[~].title.sort()");
        functionTest.add("library.size()");
        functionTest.add("library.asdad.size()");
        functionTest.add("library.books[(publisher == contains(\"Russian\"))]");
        functionTest.add("library.books[(title == reg(\"[1-9]*\"))].title");
        tests.put("FunctionTest", functionTest);

        List<String> axisTest = new ArrayList<>();
        axisTest.add("library.books[(details.available_copies == ../floor_count)].details.available_copies");
        tests.put("AxisTest", axisTest);

        List<String> hardcoreTest = new ArrayList<>();
        hardcoreTest.add("library.books[(details.available_copies == ../floor_count)].reviews[(rating > 4)].user");
        tests.put("HardcoreTest", hardcoreTest);

        for (Map.Entry<String, List<String>> list : tests.entrySet()) {
            System.out.printf("%s\n", list.getKey());
            for (String str : list.getValue()) {
                System.out.printf("softAssert.assertEquals(JsonPath.getValue(json, \"%s\"), \"%s\", \"%s\");\n", str.replaceAll("\\\"", "\\\\\""), JsonPath.getValue(json, str).replaceAll("\\\"", "\\\\\""), str.replaceAll("\\\"", "\\\\\""));
            }
            System.out.printf("\n\n\n");
        }
    }
}