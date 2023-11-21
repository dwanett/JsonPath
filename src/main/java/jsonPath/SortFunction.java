package jsonPath;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortFunction implements Function<JsonElement>{

    @Override
    public JsonElement run(JsonElement jsonElement) {
        if (jsonElement == null)
            return null;
        if (jsonElement.isJsonArray()) {
            List<JsonElement> arrayAsList = jsonElement.getAsJsonArray().asList();
            arrayAsList.sort(Comparator.comparing(x -> x.toString()));
        }
        return jsonElement;
    }
}
