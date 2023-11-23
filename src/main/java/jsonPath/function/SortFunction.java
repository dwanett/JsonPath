package jsonPath.function;

import com.google.gson.JsonElement;

import java.util.Comparator;
import java.util.List;

public class SortFunction implements Function<JsonElement>{

    @Override
    public JsonElement run(JsonElement jsonElement) {
        if (jsonElement == null)
            return null;
        if (jsonElement.isJsonArray()) {
            List<JsonElement> arrayAsList = jsonElement.getAsJsonArray().asList();
            arrayAsList.sort(Comparator.comparing(x -> {
                byte[] bytes = x.toString().getBytes();
                long sum = 0;
                for (byte aByte : bytes) sum += aByte;
                return sum;
            }));
        }
        return jsonElement;
    }
}
