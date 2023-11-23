package jsonPath.function;

import com.google.gson.JsonElement;

@FunctionalInterface
public interface Function<T> {

    T run(JsonElement jsonElement);

}
