package jsonPath;

import com.google.gson.JsonElement;

public class DiagnosticInformation {

    private JsonElement lastFoundElement;

    private JsonPathAll allJsonPath;

    private JsonPathElement problematicElement;

    private Exception lastException;

    public DiagnosticInformation(JsonElement lastFoundElement, JsonPathAll allJsonPath, JsonPathElement problematicElement, Exception lastException) {
        this.lastFoundElement = lastFoundElement;
        this.allJsonPath = allJsonPath;
        this.problematicElement = problematicElement;
        this.lastException = lastException;
    }

    public JsonElement getLastFindElement() {
        return lastFoundElement;
    }

    public JsonPathAll getAllJsonPath() {
        return allJsonPath;
    }

    public JsonPathElement getProblematicElement() {
        return problematicElement;
    }

    public Exception getLastException() {
        return lastException;
    }
}
