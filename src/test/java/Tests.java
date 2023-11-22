import com.google.gson.Gson;
import com.google.gson.JsonElement;
import jsonPath.JsonPath;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tests {

    private static final JsonElement json = new Gson().fromJson("{\n" +
            "  \"library\": {\n" +
            "    \"location\": \"New York\",\n" +
            "    \"floor_count\": 3,\n" +
            "    \"books\": [\n" +
            "      {\n" +
            "        \"title\": \"War and Peace\",\n" +
            "        \"author\": \"Leo Tolstoy\",\n" +
            "        \"publication_year\": 1869,\n" +
            "        \"genre\": \"novel\",\n" +
            "        \"publisher\": \"The Russian Messenger\",\n" +
            "        \"details\": {\n" +
            "          \"pages\": 1225,\n" +
            "          \"language\": \"Russian\",\n" +
            "          \"available_copies\": 5\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"title\": \"Crime and Punishment\",\n" +
            "        \"author\": \"Fyodor Dostoevsky\",\n" +
            "        \"publication_year\": 1866,\n" +
            "        \"genre\": \"novel\",\n" +
            "        \"publisher\": \"The Russian Messenger\",\n" +
            "        \"details\": {\n" +
            "          \"pages\": 671,\n" +
            "          \"language\": \"Russian\",\n" +
            "          \"available_copies\": 3\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"title\": \"To Kill a Mockingbird\",\n" +
            "        \"author\": \"Harper Lee\",\n" +
            "        \"publication_year\": 1960,\n" +
            "        \"genre\": \"novel\",\n" +
            "        \"publisher\": \"J.B. Lippincott & Co.\",\n" +
            "        \"details\": {\n" +
            "          \"pages\": 281,\n" +
            "          \"language\": \"English\",\n" +
            "          \"available_copies\": 7\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"title\": \"1984\",\n" +
            "        \"author\": \"George Orwell\",\n" +
            "        \"publication_year\": 1949,\n" +
            "        \"genre\": \"dystopian novel\",\n" +
            "        \"publisher\": \"Secker & Warburg\",\n" +
            "        \"details\": {\n" +
            "          \"pages\": 328,\n" +
            "          \"language\": \"English\",\n" +
            "          \"available_copies\": 4\n" +
            "        }\n" +
            "      }\n" +
            "    ],\n" +
            "    \"readers\": [\n" +
            "      {\n" +
            "        \"name\": \"Ivan\",\n" +
            "        \"age\": 25,\n" +
            "        \"books_in_possession\": [\n" +
            "          {\n" +
            "            \"title\": \"War and Peace\",\n" +
            "            \"return_date\": \"2023-10-15\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"name\": \"Maria\",\n" +
            "        \"age\": 30,\n" +
            "        \"books_in_possession\": [\n" +
            "          {\n" +
            "            \"title\": \"To Kill a Mockingbird\",\n" +
            "            \"return_date\": \"2023-09-20\"\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}", JsonElement.class);
    @Test
    public void PathTest() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(JsonPath.getValue(json, "library"), "{\"location\":\"New York\",\"floor_count\":3,\"books\":[{\"title\":\"War and Peace\",\"author\":\"Leo Tolstoy\",\"publication_year\":1869,\"genre\":\"novel\",\"publisher\":\"The Russian Messenger\",\"details\":{\"pages\":1225,\"language\":\"Russian\",\"available_copies\":5}},{\"title\":\"Crime and Punishment\",\"author\":\"Fyodor Dostoevsky\",\"publication_year\":1866,\"genre\":\"novel\",\"publisher\":\"The Russian Messenger\",\"details\":{\"pages\":671,\"language\":\"Russian\",\"available_copies\":3}},{\"title\":\"To Kill a Mockingbird\",\"author\":\"Harper Lee\",\"publication_year\":1960,\"genre\":\"novel\",\"publisher\":\"J.B. Lippincott & Co.\",\"details\":{\"pages\":281,\"language\":\"English\",\"available_copies\":7}},{\"title\":\"1984\",\"author\":\"George Orwell\",\"publication_year\":1949,\"genre\":\"dystopian novel\",\"publisher\":\"Secker & Warburg\",\"details\":{\"pages\":328,\"language\":\"English\",\"available_copies\":4}}],\"readers\":[{\"name\":\"Ivan\",\"age\":25,\"books_in_possession\":[{\"title\":\"War and Peace\",\"return_date\":\"2023-10-15\"}]},{\"name\":\"Maria\",\"age\":30,\"books_in_possession\":[{\"title\":\"To Kill a Mockingbird\",\"return_date\":\"2023-09-20\"}]}]}", "library");
        softAssert.assertEquals(JsonPath.getValue(json, "library.location"), "New York", "library.location");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books"), "[{\"title\":\"War and Peace\",\"author\":\"Leo Tolstoy\",\"publication_year\":1869,\"genre\":\"novel\",\"publisher\":\"The Russian Messenger\",\"details\":{\"pages\":1225,\"language\":\"Russian\",\"available_copies\":5}},{\"title\":\"Crime and Punishment\",\"author\":\"Fyodor Dostoevsky\",\"publication_year\":1866,\"genre\":\"novel\",\"publisher\":\"The Russian Messenger\",\"details\":{\"pages\":671,\"language\":\"Russian\",\"available_copies\":3}},{\"title\":\"To Kill a Mockingbird\",\"author\":\"Harper Lee\",\"publication_year\":1960,\"genre\":\"novel\",\"publisher\":\"J.B. Lippincott & Co.\",\"details\":{\"pages\":281,\"language\":\"English\",\"available_copies\":7}},{\"title\":\"1984\",\"author\":\"George Orwell\",\"publication_year\":1949,\"genre\":\"dystopian novel\",\"publisher\":\"Secker & Warburg\",\"details\":{\"pages\":328,\"language\":\"English\",\"available_copies\":4}}]", "library.books");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[1]"), "{\"title\":\"Crime and Punishment\",\"author\":\"Fyodor Dostoevsky\",\"publication_year\":1866,\"genre\":\"novel\",\"publisher\":\"The Russian Messenger\",\"details\":{\"pages\":671,\"language\":\"Russian\",\"available_copies\":3}}", "library.books[1]");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[~].title"), "[\"War and Peace\",\"Crime and Punishment\",\"To Kill a Mockingbird\",\"1984\"]", "library.books[~].title");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books.title"), "War and Peace", "library.books.title");

        softAssert.assertAll();
    }

    @Test
    public void ConditionTest() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(publication_year < 1868)].details.available_copies"), "3", "library.books[(publication_year < 1868)].details.available_copies");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(publication_year == 1949 || publication_year == 1866)][~].title"), "[\"Crime and Punishment\",\"1984\"]", "library.books[(publication_year == 1949 || publication_year == 1866)][~].title");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(details.pages < 500)][~].details.pages"), "[281,328]", "library.books[(details.pages < 500)][~].details.pages");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(publisher == \"The Russian Messenger\")].title"), "War and Peace", "library.books[(publisher == \"The Russian Messenger\")].title");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(publisher == \"The Russian Messenger\")][0].title"), "War and Peace", "library.books[(publisher == \"The Russian Messenger\")][0].title");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(publisher == \"The Russian Messenger\")][1].title"), "Crime and Punishment", "library.books[(publisher == \"The Russian Messenger\")][1].title");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[({author == \"Leo Tolstoy\" || author == \"Harper Lee\"} && details.pages < 500)][~].details.pages"), "[281]", "library.books[({author == \"Leo Tolstoy\" || author == \"Harper Lee\"} && details.pages < 500)][~].details.pages");
        softAssert.assertAll();
    }

    @Test
    public void FunctionTest() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(JsonPath.getValue(json, "library.books[~].details.pages.sort()"), "[281,328,671,1225]", "library.books[~].details.pages.sort()");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[~].details.pages.size()"), "4", "library.books[~].details.pages.size()");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[~].title.sort()"), "[\"1984\",\"War and Peace\",\"To Kill a Mockingbird\",\"Crime and Punishment\"]", "library.books[~].title.sort()");
        softAssert.assertEquals(JsonPath.getValue(json, "library.size()"), "1", "author.size()");
        softAssert.assertEquals(JsonPath.getValue(json, "library.asdad.size()"), "0", "author.asdad.size()");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(publisher == contains(\"Russian\"))]"), "[{\"title\":\"War and Peace\",\"author\":\"Leo Tolstoy\",\"publication_year\":1869,\"genre\":\"novel\",\"publisher\":\"The Russian Messenger\",\"details\":{\"pages\":1225,\"language\":\"Russian\",\"available_copies\":5}},{\"title\":\"Crime and Punishment\",\"author\":\"Fyodor Dostoevsky\",\"publication_year\":1866,\"genre\":\"novel\",\"publisher\":\"The Russian Messenger\",\"details\":{\"pages\":671,\"language\":\"Russian\",\"available_copies\":3}}]", "library.books[(publisher == contains(\"Russian\"))]");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(title == reg(\"[1-9]*\"))].title"), "1984", "library.books[(title == reg(\"[1-9]*\"))].title");
        softAssert.assertAll();
    }
}