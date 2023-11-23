package jsonPath;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class Main {

    public static void main(String[] args) {
        JsonElement json = new Gson().fromJson("{\n" +
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
                "            \"comment\": \"A true masterpiece.\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"user\": \"Anna\",\n" +
                "            \"rating\": 4,\n" +
                "            \"comment\": \"A bit lengthy, but beautiful.\"\n" +
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
                "            \"comment\": \"Deep and thought-provoking.\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"user\": \"Elena\",\n" +
                "            \"rating\": 4,\n" +
                "            \"comment\": \"Captivating plot.\"\n" +
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
                "            \"comment\": \"Important and impactful.\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"user\": \"John\",\n" +
                "            \"rating\": 4,\n" +
                "            \"comment\": \"A timeless classic.\"\n" +
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
                "            \"comment\": \"Frighteningly relevant.\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"user\": \"Sophia\",\n" +
                "            \"rating\": 4,\n" +
                "            \"comment\": \"A must-read for all.\"\n" +
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

        System.out.println(JsonPath.getValue(json, "library.books[(pole == null)].title"));
    }
}