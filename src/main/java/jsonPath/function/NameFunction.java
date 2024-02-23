package jsonPath.function;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Set;

public class NameFunction implements Function<JsonElement>{

    @Override
    public JsonElement run(JsonElement jsonElement) {
        JsonElement result = new JsonArray();
        if (jsonElement == null
                || jsonElement.isJsonPrimitive()
                || jsonElement.isJsonNull())
            return null;

        if (jsonElement.isJsonObject()) {
            ((JsonObject) jsonElement).entrySet().forEach(x -> result.getAsJsonArray().add(x.getKey()));
        } else if (jsonElement.isJsonArray()) {
            Set<String> names = new HashSet<>();
            for (JsonElement elementList : jsonElement.getAsJsonArray().asList()) {
                if (!(elementList.isJsonPrimitive() || elementList.isJsonNull() || elementList.isJsonArray()))
                    ((JsonObject) elementList).entrySet().forEach(x -> names.add(x.getKey()));
            }
            names.forEach(x-> result.getAsJsonArray().add(x));

        }
        return result;
    }
}
