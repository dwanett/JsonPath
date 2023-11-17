package jsonPath;

public class JsonPathException extends RuntimeException {

    private JsonPath jsonPath;
    private JsonPathElement exceptedJsonPathElement;

    public JsonPathException (String messages, JsonPath jsonPath, JsonPathElement exceptedJsonPathElement) {
        super(messages);
        this.jsonPath = jsonPath;
        this.exceptedJsonPathElement = exceptedJsonPathElement;
    }

    public JsonPath getJsonPath() {
        return jsonPath;
    }

    public JsonPathElement getExceptedJsonPathElement() {
        return exceptedJsonPathElement;
    }

}
