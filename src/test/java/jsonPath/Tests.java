package jsonPath;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
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
                    "        \"pole\": null,\n" +
                    "        \"object\": {},\n" +
                    "        \"array\": [],\n" +
                    "        \"publisher\": \"The Russian Messenger\",\n" +
                    "        \"details\": {\n" +
                    "          \"pages\": 1225,\n" +
                    "          \"language\": \"Russian\",\n" +
                    "          \"available_copies\": 5\n" +
                    "        },\n" +
                    "        \"categories\": [\n" +
                    "          \"classic\",\n" +
                    "          \"historical\"\n" +
                    "        ],\n" +
                    "        \"reviews\": [\n" +
                    "          {\n" +
                    "            \"user\": \"Alex\",\n" +
                    "            \"rating\": 5,\n" +
                    "            \"comment\": \"A true masterpiece.\",\n" +
                    "            \"awards\": [\n" +
                    "              {\n" +
                    "                \"name\": \"Book of the Year\",\n" +
                    "                \"type\": \"main award\",\n" +
                    "                \"prize\": 1500\n" +
                    "              },\n" +
                    "              {\n" +
                    "                \"name\": \"Best Debut\",\n" +
                    "                \"type\": \"special award\",\n" +
                    "                \"prize\": 500\n" +
                    "              },\n" +
                    "              {\n" +
                    "                \"name\": \"Readers’ Choice\",\n" +
                    "                \"type\": \"popular award\",\n" +
                    "                \"prize\": 300\n" +
                    "              }\n" +
                    "            ]\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"user\": \"Anna\",\n" +
                    "            \"rating\": 4,\n" +
                    "            \"comment\": \"A bit lengthy, but beautiful.\",\n" +
                    "            \"awards\": [\n" +
                    "              {\n" +
                    "                \"name\": \"Book of the Year\",\n" +
                    "                \"type\": \"main award\",\n" +
                    "                \"prize\": 1500\n" +
                    "              },\n" +
                    "              {\n" +
                    "                \"name\": \"Best Debut\",\n" +
                    "                \"type\": \"special award\",\n" +
                    "                \"prize\": 1500\n" +
                    "              },\n" +
                    "              {\n" +
                    "                \"name\": \"Readers’ Choice\",\n" +
                    "                \"type\": \"popular award\",\n" +
                    "                \"prize\": 1500\n" +
                    "              }\n" +
                    "            ]\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"title\": \"Crime and Punishment\",\n" +
                    "        \"author\": \"Fyodor Dostoevsky\",\n" +
                    "        \"publication_year\": 1866,\n" +
                    "        \"genre\": \"novel\",\n" +
                    "        \"pole\": \"das\",\n" +
                    "        \"object\": {},\n" +
                    "        \"publisher\": \"The Russian Messenger\",\n" +
                    "        \"details\": {\n" +
                    "          \"pages\": 671,\n" +
                    "          \"language\": \"Russian\",\n" +
                    "          \"available_copies\": 3\n" +
                    "        },\n" +
                    "        \"categories\": [\n" +
                    "          \"classic\",\n" +
                    "          \"psychological\"\n" +
                    "        ],\n" +
                    "        \"reviews\": [\n" +
                    "          {\n" +
                    "            \"user\": \"Sergei\",\n" +
                    "            \"rating\": 5,\n" +
                    "            \"comment\": \"Deep and thought-provoking.\",\n" +
                    "            \"awards\": [\n" +
                    "              {\n" +
                    "                \"name\": \"Book of the Year\",\n" +
                    "                \"type\": \"main award\",\n" +
                    "                \"prize\": 200\n" +
                    "              },\n" +
                    "              {\n" +
                    "                \"name\": \"Best Debut\",\n" +
                    "                \"type\": \"special award\",\n" +
                    "                \"prize\": 400\n" +
                    "              },\n" +
                    "              {\n" +
                    "                \"name\": \"Readers’ Choice\",\n" +
                    "                \"type\": \"popular award\",\n" +
                    "                \"prize\": 600\n" +
                    "              }\n" +
                    "            ]\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"user\": \"Elena\",\n" +
                    "            \"rating\": 4,\n" +
                    "            \"comment\": \"Captivating plot.\",\n" +
                    "            \"awards\": [\n" +
                    "              {\n" +
                    "                \"name\": \"Book of the Year\",\n" +
                    "                \"type\": \"main award\",\n" +
                    "                \"prize\": 800\n" +
                    "              },\n" +
                    "              {\n" +
                    "                \"name\": \"Best Debut\",\n" +
                    "                \"type\": \"special award\",\n" +
                    "                \"prize\": 300\n" +
                    "              },\n" +
                    "              {\n" +
                    "                \"name\": \"Readers’ Choice\",\n" +
                    "                \"type\": \"popular award\",\n" +
                    "                \"prize\": 1000\n" +
                    "              }\n" +
                    "            ]\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"title\": \"To Kill a Mockingbird\",\n" +
                    "        \"author\": \"Harper Lee\",\n" +
                    "        \"publication_year\": 1960,\n" +
                    "        \"genre\": \"novel\",\n" +
                    "        \"pole\": \"null\",\n" +
                    "        \"object\": {},\n" +
                    "        \"publisher\": \"J.B. Lippincott & Co.\",\n" +
                    "        \"details\": {\n" +
                    "          \"pages\": 281,\n" +
                    "          \"language\": \"English\",\n" +
                    "          \"available_copies\": 7\n" +
                    "        },\n" +
                    "        \"categories\": [\n" +
                    "          \"classic\",\n" +
                    "          \"social justice\"\n" +
                    "        ],\n" +
                    "        \"reviews\": [\n" +
                    "          {\n" +
                    "            \"user\": \"Mary\",\n" +
                    "            \"rating\": 5,\n" +
                    "            \"comment\": \"Important and impactful.\",\n" +
                    "            \"awards\": [\n" +
                    "              {\n" +
                    "                \"name\": \"Book of the Year\",\n" +
                    "                \"type\": \"main award\",\n" +
                    "                \"prize\": 1500\n" +
                    "              },\n" +
                    "              {\n" +
                    "                \"name\": \"Best Debut\",\n" +
                    "                \"type\": \"special award\",\n" +
                    "                \"prize\": 1500\n" +
                    "              },\n" +
                    "              {\n" +
                    "                \"name\": \"Readers’ Choice\",\n" +
                    "                \"type\": \"popular award\",\n" +
                    "                \"prize\": 1500\n" +
                    "              }\n" +
                    "            ]\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"user\": \"John\",\n" +
                    "            \"rating\": 4,\n" +
                    "            \"comment\": \"A timeless classic.\",\n" +
                    "            \"awards\": [\n" +
                    "              {\n" +
                    "                \"name\": \"Book of the Year\",\n" +
                    "                \"type\": \"main award\",\n" +
                    "                \"prize\": 1500\n" +
                    "              },\n" +
                    "              {\n" +
                    "                \"name\": \"Best Debut\",\n" +
                    "                \"type\": \"special award\",\n" +
                    "                \"prize\": 1500\n" +
                    "              },\n" +
                    "              {\n" +
                    "                \"name\": \"Readers’ Choice\",\n" +
                    "                \"type\": \"popular award\",\n" +
                    "                \"prize\": 1500\n" +
                    "              }\n" +
                    "            ]\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"title\": \"1984\",\n" +
                    "        \"author\": \"George Orwell\",\n" +
                    "        \"publication_year\": 1949,\n" +
                    "        \"genre\": \"dystopian novel\",\n" +
                    "        \"pole\": null,\n" +
                    "        \"object\": {},\n" +
                    "        \"publisher\": \"Secker & Warburg\",\n" +
                    "        \"details\": {\n" +
                    "          \"pages\": 328,\n" +
                    "          \"language\": \"English\",\n" +
                    "          \"available_copies\": 4\n" +
                    "        },\n" +
                    "        \"categories\": [\n" +
                    "          \"dystopian\",\n" +
                    "          \"political\"\n" +
                    "        ],\n" +
                    "        \"reviews\": [\n" +
                    "          {\n" +
                    "            \"user\": \"Peter\",\n" +
                    "            \"rating\": 5,\n" +
                    "            \"test\": 5,\n" +
                    "            \"comment\": \"Frighteningly relevant.\",\n" +
                    "            \"awards\": [\n" +
                    "              {\n" +
                    "                \"name\": \"Book of the Year\",\n" +
                    "                \"type\": \"main award\",\n" +
                    "                \"prize\": 1000\n" +
                    "              },\n" +
                    "              {\n" +
                    "                \"name\": \"Best Debut\",\n" +
                    "                \"type\": \"special award\",\n" +
                    "                \"prize\": 500\n" +
                    "              },\n" +
                    "              {\n" +
                    "                \"name\": \"Readers’ Choice\",\n" +
                    "                \"type\": \"popular award\",\n" +
                    "                \"prize\": 300\n" +
                    "              }\n" +
                    "            ]\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"user\": \"Sophia\",\n" +
                    "            \"rating\": 5,\n" +
                    "            \"comment\": \"A must-read for all.\",\n" +
                    "            \"awards\": [\n" +
                    "              {\n" +
                    "                \"name\": \"Book of the Year\",\n" +
                    "                \"type\": \"main award\",\n" +
                    "                \"prize\": 1000\n" +
                    "              },\n" +
                    "              {\n" +
                    "                \"name\": \"Best Debut\",\n" +
                    "                \"type\": \"special award\",\n" +
                    "                \"prize\": 500\n" +
                    "              },\n" +
                    "              {\n" +
                    "                \"name\": \"Readers’ Choice\",\n" +
                    "                \"type\": \"popular award\",\n" +
                    "                \"prize\": 300\n" +
                    "              }\n" +
                    "            ]\n" +
                    "          }\n" +
                    "        ]\n" +
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

        softAssert.assertEquals(JsonPath.getValue(json, "library"), "{\"location\":\"New York\",\"floor_count\":3,\"books\":[{\"title\":\"War and Peace\",\"author\":\"Leo Tolstoy\",\"publication_year\":1869,\"genre\":\"novel\",\"pole\":null,\"object\":{},\"array\":[],\"publisher\":\"The Russian Messenger\",\"details\":{\"pages\":1225,\"language\":\"Russian\",\"available_copies\":5},\"categories\":[\"classic\",\"historical\"],\"reviews\":[{\"user\":\"Alex\",\"rating\":5,\"comment\":\"A true masterpiece.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":300}]},{\"user\":\"Anna\",\"rating\":4,\"comment\":\"A bit lengthy, but beautiful.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":1500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1500}]}]},{\"title\":\"Crime and Punishment\",\"author\":\"Fyodor Dostoevsky\",\"publication_year\":1866,\"genre\":\"novel\",\"pole\":\"das\",\"object\":{},\"publisher\":\"The Russian Messenger\",\"details\":{\"pages\":671,\"language\":\"Russian\",\"available_copies\":3},\"categories\":[\"classic\",\"psychological\"],\"reviews\":[{\"user\":\"Sergei\",\"rating\":5,\"comment\":\"Deep and thought-provoking.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":200},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":400},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":600}]},{\"user\":\"Elena\",\"rating\":4,\"comment\":\"Captivating plot.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":800},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":300},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1000}]}]},{\"title\":\"To Kill a Mockingbird\",\"author\":\"Harper Lee\",\"publication_year\":1960,\"genre\":\"novel\",\"pole\":\"null\",\"object\":{},\"publisher\":\"J.B. Lippincott & Co.\",\"details\":{\"pages\":281,\"language\":\"English\",\"available_copies\":7},\"categories\":[\"classic\",\"social justice\"],\"reviews\":[{\"user\":\"Mary\",\"rating\":5,\"comment\":\"Important and impactful.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":1500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1500}]},{\"user\":\"John\",\"rating\":4,\"comment\":\"A timeless classic.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":1500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1500}]}]},{\"title\":\"1984\",\"author\":\"George Orwell\",\"publication_year\":1949,\"genre\":\"dystopian novel\",\"pole\":null,\"object\":{},\"publisher\":\"Secker & Warburg\",\"details\":{\"pages\":328,\"language\":\"English\",\"available_copies\":4},\"categories\":[\"dystopian\",\"political\"],\"reviews\":[{\"user\":\"Peter\",\"rating\":5,\"test\":5,\"comment\":\"Frighteningly relevant.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1000},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":300}]},{\"user\":\"Sophia\",\"rating\":5,\"comment\":\"A must-read for all.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1000},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":300}]}]}],\"readers\":[{\"name\":\"Ivan\",\"age\":25,\"books_in_possession\":[{\"title\":\"War and Peace\",\"return_date\":\"2023-10-15\"}]},{\"name\":\"Maria\",\"age\":30,\"books_in_possession\":[{\"title\":\"To Kill a Mockingbird\",\"return_date\":\"2023-09-20\"}]}]}", "library");
        softAssert.assertEquals(JsonPath.getValue(json, "library.location"), "New York", "library.location");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books"), "[{\"title\":\"War and Peace\",\"author\":\"Leo Tolstoy\",\"publication_year\":1869,\"genre\":\"novel\",\"pole\":null,\"object\":{},\"array\":[],\"publisher\":\"The Russian Messenger\",\"details\":{\"pages\":1225,\"language\":\"Russian\",\"available_copies\":5},\"categories\":[\"classic\",\"historical\"],\"reviews\":[{\"user\":\"Alex\",\"rating\":5,\"comment\":\"A true masterpiece.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":300}]},{\"user\":\"Anna\",\"rating\":4,\"comment\":\"A bit lengthy, but beautiful.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":1500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1500}]}]},{\"title\":\"Crime and Punishment\",\"author\":\"Fyodor Dostoevsky\",\"publication_year\":1866,\"genre\":\"novel\",\"pole\":\"das\",\"object\":{},\"publisher\":\"The Russian Messenger\",\"details\":{\"pages\":671,\"language\":\"Russian\",\"available_copies\":3},\"categories\":[\"classic\",\"psychological\"],\"reviews\":[{\"user\":\"Sergei\",\"rating\":5,\"comment\":\"Deep and thought-provoking.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":200},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":400},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":600}]},{\"user\":\"Elena\",\"rating\":4,\"comment\":\"Captivating plot.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":800},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":300},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1000}]}]},{\"title\":\"To Kill a Mockingbird\",\"author\":\"Harper Lee\",\"publication_year\":1960,\"genre\":\"novel\",\"pole\":\"null\",\"object\":{},\"publisher\":\"J.B. Lippincott & Co.\",\"details\":{\"pages\":281,\"language\":\"English\",\"available_copies\":7},\"categories\":[\"classic\",\"social justice\"],\"reviews\":[{\"user\":\"Mary\",\"rating\":5,\"comment\":\"Important and impactful.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":1500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1500}]},{\"user\":\"John\",\"rating\":4,\"comment\":\"A timeless classic.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":1500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1500}]}]},{\"title\":\"1984\",\"author\":\"George Orwell\",\"publication_year\":1949,\"genre\":\"dystopian novel\",\"pole\":null,\"object\":{},\"publisher\":\"Secker & Warburg\",\"details\":{\"pages\":328,\"language\":\"English\",\"available_copies\":4},\"categories\":[\"dystopian\",\"political\"],\"reviews\":[{\"user\":\"Peter\",\"rating\":5,\"test\":5,\"comment\":\"Frighteningly relevant.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1000},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":300}]},{\"user\":\"Sophia\",\"rating\":5,\"comment\":\"A must-read for all.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1000},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":300}]}]}]", "library.books");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[1]"), "{\"title\":\"Crime and Punishment\",\"author\":\"Fyodor Dostoevsky\",\"publication_year\":1866,\"genre\":\"novel\",\"pole\":\"das\",\"object\":{},\"publisher\":\"The Russian Messenger\",\"details\":{\"pages\":671,\"language\":\"Russian\",\"available_copies\":3},\"categories\":[\"classic\",\"psychological\"],\"reviews\":[{\"user\":\"Sergei\",\"rating\":5,\"comment\":\"Deep and thought-provoking.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":200},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":400},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":600}]},{\"user\":\"Elena\",\"rating\":4,\"comment\":\"Captivating plot.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":800},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":300},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1000}]}]}", "library.books[1]");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[~].title"), "[\"War and Peace\",\"Crime and Punishment\",\"To Kill a Mockingbird\",\"1984\"]", "library.books[~].title");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books.title"), "War and Peace", "library.books.title");

        softAssert.assertAll();
    }

    @Test
    public void ConditionTest() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(publication_year < 1868)].details.available_copies"), "3", "library.books[(publication_year < 1868)].details.available_copies");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(publication_year == 1949 <> publication_year == 1866)][~].title"), "[\"Crime and Punishment\",\"1984\"]", "library.books[(publication_year == 1949 <> publication_year == 1866)][~].title");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(details.pages < 500)][~].details.pages"), "[281,328]", "library.books[(details.pages < 500)][~].details.pages");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(publisher == \"The Russian Messenger\")].title"), "War and Peace", "library.books[(publisher == \"The Russian Messenger\")].title");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(publisher == \"The Russian Messenger\")][0].title"), "War and Peace", "library.books[(publisher == \"The Russian Messenger\")][0].title");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(publisher == \"The Russian Messenger\")][1].title"), "Crime and Punishment", "library.books[(publisher == \"The Russian Messenger\")][1].title");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[({author == \"Leo Tolstoy\" <> author == \"Harper Lee\"} && details.pages < 500)][~].details.pages"), "[281]", "library.books[({author == \"Leo Tolstoy\" <> author == \"Harper Lee\"} && details.pages < 500)][~].details.pages");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(reviews[(user == \"Mary\")])]"), "[{\"title\":\"To Kill a Mockingbird\",\"author\":\"Harper Lee\",\"publication_year\":1960,\"genre\":\"novel\",\"pole\":\"null\",\"object\":{},\"publisher\":\"J.B. Lippincott & Co.\",\"details\":{\"pages\":281,\"language\":\"English\",\"available_copies\":7},\"categories\":[\"classic\",\"social justice\"],\"reviews\":[{\"user\":\"Mary\",\"rating\":5,\"comment\":\"Important and impactful.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":1500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1500}]},{\"user\":\"John\",\"rating\":4,\"comment\":\"A timeless classic.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":1500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1500}]}]}]", "library.books[(reviews[(user == \"Mary\")])]");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(reviews)]"), "[{\"title\":\"War and Peace\",\"author\":\"Leo Tolstoy\",\"publication_year\":1869,\"genre\":\"novel\",\"pole\":null,\"object\":{},\"array\":[],\"publisher\":\"The Russian Messenger\",\"details\":{\"pages\":1225,\"language\":\"Russian\",\"available_copies\":5},\"categories\":[\"classic\",\"historical\"],\"reviews\":[{\"user\":\"Alex\",\"rating\":5,\"comment\":\"A true masterpiece.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":300}]},{\"user\":\"Anna\",\"rating\":4,\"comment\":\"A bit lengthy, but beautiful.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":1500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1500}]}]},{\"title\":\"Crime and Punishment\",\"author\":\"Fyodor Dostoevsky\",\"publication_year\":1866,\"genre\":\"novel\",\"pole\":\"das\",\"object\":{},\"publisher\":\"The Russian Messenger\",\"details\":{\"pages\":671,\"language\":\"Russian\",\"available_copies\":3},\"categories\":[\"classic\",\"psychological\"],\"reviews\":[{\"user\":\"Sergei\",\"rating\":5,\"comment\":\"Deep and thought-provoking.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":200},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":400},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":600}]},{\"user\":\"Elena\",\"rating\":4,\"comment\":\"Captivating plot.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":800},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":300},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1000}]}]},{\"title\":\"To Kill a Mockingbird\",\"author\":\"Harper Lee\",\"publication_year\":1960,\"genre\":\"novel\",\"pole\":\"null\",\"object\":{},\"publisher\":\"J.B. Lippincott & Co.\",\"details\":{\"pages\":281,\"language\":\"English\",\"available_copies\":7},\"categories\":[\"classic\",\"social justice\"],\"reviews\":[{\"user\":\"Mary\",\"rating\":5,\"comment\":\"Important and impactful.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":1500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1500}]},{\"user\":\"John\",\"rating\":4,\"comment\":\"A timeless classic.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":1500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1500}]}]},{\"title\":\"1984\",\"author\":\"George Orwell\",\"publication_year\":1949,\"genre\":\"dystopian novel\",\"pole\":null,\"object\":{},\"publisher\":\"Secker & Warburg\",\"details\":{\"pages\":328,\"language\":\"English\",\"available_copies\":4},\"categories\":[\"dystopian\",\"political\"],\"reviews\":[{\"user\":\"Peter\",\"rating\":5,\"test\":5,\"comment\":\"Frighteningly relevant.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1000},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":300}]},{\"user\":\"Sophia\",\"rating\":5,\"comment\":\"A must-read for all.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1000},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":300}]}]}]", "library.books[(reviews)]");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(author == \"George Orwell\" && title == \"1984\" <> title == \"War and Peace\" && publication_year == 1869)][~].title"), "[\"War and Peace\",\"1984\"]", "library.books[(author == \"George Orwell\" && title == \"1984\" <> title == \"War and Peace\" && publication_year == 1869)][~].title");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(author == \"George Orwell\" && {title == \"1984\" <> title == \"War and Peace\"} && publication_year == 1869)][~].title"), "[]", "library.books[(author == \"George Orwell\" && {title == \"1984\" <> title == \"War and Peace\"} && publication_year == 1869)][~].title");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(reviews[nonMatch(rating == 6)])][~].title"), "[\"War and Peace\",\"Crime and Punishment\",\"To Kill a Mockingbird\",\"1984\"]", "library.books[(reviews[!(rating == 6)])][~].title");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(reviews[nonMatch(rating == 5)])][~].title"), "[]", "library.books[(reviews[!(rating == 5)])][~].title");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(reviews[nonMatch(rating == 4)])][~].title"), "[\"1984\"]", "library.books[(reviews[!(rating == 4)])][~].title");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(reviews[allMatch(rating == 4)])][~].title"), "[]", "library.books[(reviews[*(rating == 4)])][~].title");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(reviews[allMatch(rating == 5)])][~].title"), "[\"1984\"]", "library.books[(reviews[*(rating == 5)])][~].title");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(reviews[(awards[allMatch(prize == 1500)])])]"), "[{\"title\":\"War and Peace\",\"author\":\"Leo Tolstoy\",\"publication_year\":1869,\"genre\":\"novel\",\"pole\":null,\"object\":{},\"array\":[],\"publisher\":\"The Russian Messenger\",\"details\":{\"pages\":1225,\"language\":\"Russian\",\"available_copies\":5},\"categories\":[\"classic\",\"historical\"],\"reviews\":[{\"user\":\"Alex\",\"rating\":5,\"comment\":\"A true masterpiece.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":300}]},{\"user\":\"Anna\",\"rating\":4,\"comment\":\"A bit lengthy, but beautiful.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":1500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1500}]}]},{\"title\":\"To Kill a Mockingbird\",\"author\":\"Harper Lee\",\"publication_year\":1960,\"genre\":\"novel\",\"pole\":\"null\",\"object\":{},\"publisher\":\"J.B. Lippincott & Co.\",\"details\":{\"pages\":281,\"language\":\"English\",\"available_copies\":7},\"categories\":[\"classic\",\"social justice\"],\"reviews\":[{\"user\":\"Mary\",\"rating\":5,\"comment\":\"Important and impactful.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":1500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1500}]},{\"user\":\"John\",\"rating\":4,\"comment\":\"A timeless classic.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":1500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1500}]}]}]", "library.books[(reviews[(awards[*(prize == 1500)])])]");

        softAssert.assertAll();
    }

    @Test
    public void FunctionTest() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(JsonPath.getValue(json, "library.books[~].details.pages.sort()"), "[281,328,671,1225]", "library.books[~].details.pages.sort()");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[~].details.pages.size()"), "4", "library.books[~].details.pages.size()");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[~].title.sort()"), "[\"1984\",\"War and Peace\",\"To Kill a Mockingbird\",\"Crime and Punishment\"]", "library.books[~].title.sort()");
        softAssert.assertEquals(JsonPath.getValue(json, "library.size()"), "1", "library.size()");
        softAssert.assertEquals(JsonPath.getValue(json, "library.asdad.size()"), "0", "library.asdad.size()");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(publisher == contains(\"Russian\"))]"), "[{\"title\":\"War and Peace\",\"author\":\"Leo Tolstoy\",\"publication_year\":1869,\"genre\":\"novel\",\"pole\":null,\"object\":{},\"array\":[],\"publisher\":\"The Russian Messenger\",\"details\":{\"pages\":1225,\"language\":\"Russian\",\"available_copies\":5},\"categories\":[\"classic\",\"historical\"],\"reviews\":[{\"user\":\"Alex\",\"rating\":5,\"comment\":\"A true masterpiece.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":300}]},{\"user\":\"Anna\",\"rating\":4,\"comment\":\"A bit lengthy, but beautiful.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":1500},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":1500},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1500}]}]},{\"title\":\"Crime and Punishment\",\"author\":\"Fyodor Dostoevsky\",\"publication_year\":1866,\"genre\":\"novel\",\"pole\":\"das\",\"object\":{},\"publisher\":\"The Russian Messenger\",\"details\":{\"pages\":671,\"language\":\"Russian\",\"available_copies\":3},\"categories\":[\"classic\",\"psychological\"],\"reviews\":[{\"user\":\"Sergei\",\"rating\":5,\"comment\":\"Deep and thought-provoking.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":200},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":400},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":600}]},{\"user\":\"Elena\",\"rating\":4,\"comment\":\"Captivating plot.\",\"awards\":[{\"name\":\"Book of the Year\",\"type\":\"main award\",\"prize\":800},{\"name\":\"Best Debut\",\"type\":\"special award\",\"prize\":300},{\"name\":\"Readers’ Choice\",\"type\":\"popular award\",\"prize\":1000}]}]}]", "library.books[(publisher == contains(\"Russian\"))]");
        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(title == reg(\"[1-9]*\"))].title"), "1984", "library.books[(title == reg(\"[1-9]*\"))].title");

        softAssert.assertAll();
    }

    @Test
    public void AxisTest() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(details.available_copies == ../floor_count)].details.available_copies"), "3", "library.books[(details.available_copies == ../floor_count)].details.available_copies");

        softAssert.assertAll();
    }


    @Test
    public void HardcoreTest() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(JsonPath.getValue(json, "library.books[(details.available_copies == ../floor_count)].reviews[(rating > 4)].user"), "Sergei", "library.books[(details.available_copies == ../floor_count)].reviews[(rating > 4)].user");

        softAssert.assertAll();
    }
}