package jsonPath;

import com.google.gson.JsonElement;

public class SizeFunction implements Function<Integer> {

    @Override
    public Integer run(JsonElement jsonElement) {
        if (jsonElement == null)
            return 0;
        if (jsonElement.isJsonArray())
            return jsonElement.getAsJsonArray().size();
        return 1;
    }

}
