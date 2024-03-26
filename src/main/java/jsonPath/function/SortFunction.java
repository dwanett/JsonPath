package jsonPath.function;

import com.google.gson.JsonElement;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortFunction implements Function<JsonElement>{

    @Override
    public JsonElement run(JsonElement jsonElement) {
        if (jsonElement == null)
            return null;
        if (jsonElement.isJsonArray()) {
            Comparator<JsonElement> compareJsonElement = (JsonElement x, JsonElement y) -> {
                int sum_X = 0;
                int sum_Y = 0;
                for (byte aByte : x.toString().getBytes()) sum_X += aByte;
                for (byte aByte : y.toString().getBytes()) sum_Y += aByte;
                if (sum_X != sum_Y)
                    return sum_X - sum_Y;
                return x.toString().compareTo(y.toString());
            };
            List<JsonElement> arrayAsList = jsonElement.getAsJsonArray().asList();
            arrayAsList.sort(compareJsonElement);
        }
        return jsonElement;
    }
}
