package jsonPath.function;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.HashSet;
import java.util.Set;

public class DistinctFunction implements Function<JsonElement>{

    @Override
    public JsonElement run(JsonElement jsonElement) {
        if (jsonElement == null)
            return null;
        if (jsonElement.isJsonArray()) {
            Set<JsonElement> tmpSet = new HashSet<>(((JsonArray) jsonElement).asList());
            jsonElement = new JsonArray();
            for (JsonElement element : tmpSet)
                jsonElement.getAsJsonArray().add(element);
        }
        return jsonElement;
    }
}
