package jsonPath;

import com.google.gson.JsonElement;

@FunctionalInterface
public interface Function<T> {

    public T run(JsonElement jsonElement);

}
