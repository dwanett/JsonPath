package jsonPath.errors;

import jsonPath.JsonPath;
import jsonPath.JsonPathElement;

public class JsonPathException extends RuntimeException {

    private JsonPath jsonPath;
    private JsonPathElement exceptedJsonPathElement;

    public JsonPathException (String messages, JsonPath jsonPath, JsonPathElement exceptedJsonPathElement) {
        super(messages);
        this.jsonPath = jsonPath;
        this.exceptedJsonPathElement = exceptedJsonPathElement;
    }

    public JsonPathException (String messages) {
        super(messages);
    }
    public JsonPathException (RuntimeException messages) {
        super(messages);
    }


    public JsonPath getJsonPath() {
        return jsonPath;
    }

    public JsonPathElement getExceptedJsonPathElement() {
        return exceptedJsonPathElement;
    }

}
