package jsonPath;

import antlr.JsonPathParser;
import com.google.gson.JsonElement;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;
import java.util.function.BiPredicate;

public class Expression extends BaseModel<Expression> {

    private JsonPathElement jsonPathElement;

    private CompareType compareType;

    private enum CompareType {
        EQUALS(BaseModel.getLiteralValue(JsonPathParser.EQUALS)),
        NOT_EQUALS(BaseModel.getLiteralValue(JsonPathParser.NOT_EQUALS)),
        LESS(BaseModel.getLiteralValue(JsonPathParser.LESS)),
        LESS_OR_EQUALS(BaseModel.getLiteralValue(JsonPathParser.LESS_OR_EQUALS)),
        GREATER(BaseModel.getLiteralValue(JsonPathParser.GREATER)),
        GREATER_OR_EQUALS(BaseModel.getLiteralValue(JsonPathParser.GREATER_OR_EQUALS));

        private String str;

        CompareType(String str) {
            this.str = str;
        }

        public static CompareType getCompareType(String str) {
            for (CompareType cur : values()) {
                if (cur.str.equals(str))
                    return cur;
            }
            return null;
        }
    }

    private Double doubleValue;

    private Long longValue;

    private String stringValue;

    private enum FunctionForCompare {
        REG("reg", (left, right) -> left.matches(right.substring(5, right.length() - 2))),
        CONTAINS("contains", (left, right) -> left.contains(right.substring(10, right.length() - 2)));

        private String str;

        private BiPredicate<String, String> func;

        FunctionForCompare(String str, BiPredicate<String, String> func) {
            this.str = str;
            this.func = func;
        }

        public static FunctionForCompare getFunctionForCompare(String str) {
            for (FunctionForCompare cur : values()) {
                if (str.contains(cur.str))
                    return cur;
            }
            return null;
        }
    }

    private FunctionForCompare functionForCompare;
    private List<TerminalNode> back = null;

    private JsonPathElement jsonPathElementSecond;


    @Override
    public Expression visitExpr(JsonPathParser.ExprContext ctx) {
        jsonPathElement = new JsonPathElement();
        jsonPathElement.prevJsonPathElement = this.prevJsonPathElement;
        jsonPathElement.visit(ctx.getChild(0));
        if (ctx.getChildCount() > 1) {
            compareType = CompareType.getCompareType(ctx.getChild(1).getText());

            if (ctx.BACK() != null && !ctx.BACK().isEmpty()) {
                back = ctx.BACK();
                jsonPathElementSecond = new JsonPathElement();
                jsonPathElementSecond.prevJsonPathElement = this.prevJsonPathElement;
                jsonPathElementSecond.visit(ctx.jsonPathElement(1));

            } else {
                try {
                    longValue = Long.valueOf(ctx.getChild(2).getText());
                } catch (Exception eInteger) {
                    try {
                        doubleValue = Double.valueOf(ctx.getChild(2).getText());
                    } catch (Exception eDouble) {
                        stringValue = ctx.getChild(2).getText();
                        functionForCompare = FunctionForCompare.getFunctionForCompare(stringValue);
                        if (functionForCompare == null)
                            stringValue = stringValue.substring(1, ctx.getChild(2).getText().length() - 1);
                    }
                }
            }
        }
        return this;
    }

    public Boolean compare(JsonElement curJson) {
        String leftValue = convertJsonToString(jsonPathElement.read(curJson));
        Boolean result = false;

        if (back != null)
            stringValue = runBack();

        try {
            if (doubleValue != null) {
                switch (compareType) {
                    case EQUALS : result = Double.valueOf(leftValue).equals(doubleValue); break;
                    case NOT_EQUALS : result = !Double.valueOf(leftValue).equals(doubleValue); break;
                    case LESS : result = Double.parseDouble(leftValue) < doubleValue; break;
                    case LESS_OR_EQUALS : result = Double.parseDouble(leftValue) <= doubleValue; break;
                    case GREATER : result = Double.parseDouble(leftValue) > doubleValue; break;
                    case GREATER_OR_EQUALS : result = Double.parseDouble(leftValue) >= doubleValue; break;

                };
            } else if (longValue != null) {
                switch (compareType) {
                    case EQUALS : result = Long.valueOf(leftValue).equals(longValue); break;
                    case NOT_EQUALS : result = !Long.valueOf(leftValue).equals(longValue); break;
                    case LESS : result = Long.parseLong(leftValue) < longValue; break;
                    case LESS_OR_EQUALS : result = Long.parseLong(leftValue) <= longValue; break;
                    case GREATER : result = Long.parseLong(leftValue) > longValue; break;
                    case GREATER_OR_EQUALS : result = Long.parseLong(leftValue) >= longValue; break;
                };
            } else if (stringValue != null) {
                switch (compareType) {
                    case EQUALS : result = (functionForCompare != null) ? functionForCompare.func.test(leftValue, stringValue) : leftValue.equals(stringValue); break;
                    case NOT_EQUALS : result = (functionForCompare != null) ? !functionForCompare.func.test(leftValue, stringValue) : !leftValue.equals(stringValue); break;
                    default : result = false;
                };
            } else
                result = !leftValue.equals("null");
        } catch (Exception e) {
            return false;
        }
        return result;
    }

    private String runBack() {
        JsonPathElement curJsonPathElement = this.prevJsonPathElement;
        for (int i = 0; i < back.size(); i++)
            curJsonPathElement = curJsonPathElement.prevJsonPathElement;
        JsonPathElement saveNextJsonPathElement = curJsonPathElement.getNextJsonPathElement();
        curJsonPathElement.replaceNextJsonPathElement(jsonPathElementSecond);
        JsonPathElement rootJsonPathElement = curJsonPathElement;
        while (rootJsonPathElement.prevJsonPathElement != null)
            rootJsonPathElement = rootJsonPathElement.prevJsonPathElement;
        String result = convertJsonToString(rootJsonPathElement.read(immutableJson));
        curJsonPathElement.replaceNextJsonPathElement(saveNextJsonPathElement);
        return result;
    }
}
