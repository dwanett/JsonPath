package jsonPath;

import antlr.JsonPathBaseVisitor;
import antlr.JsonPathParser;
import com.google.gson.JsonElement;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

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
        CompareType(String str) {this.str = str;}

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
        REG("reg"),
        CONTAINS("contains");

        private String str;
        FunctionForCompare(String str) {this.str = str;}

        public static FunctionForCompare getFunctionForCompare(String str) {
            for (FunctionForCompare cur : values()) {
                if (str.contains(cur.str))
                    return cur;
            }
            return null;
        }
    }

    private FunctionForCompare functionForCompare;
    private List<TerminalNode> back;

    private JsonPathElement jsonPathElementSecond;


    @Override
    public Expression visitExpr(JsonPathParser.ExprContext ctx) {
        jsonPathElement = new JsonPathElement().visit(ctx.getChild(0));
        jsonPathElement.prevJsonPathElement = this.prevJsonPathElement;
        if (ctx.getChildCount() > 1) {
            compareType = CompareType.getCompareType(ctx.getChild(1).getText());

            if (ctx.getChildCount() == 4) {
                back = ctx.BACK();
                jsonPathElementSecond = new JsonPathElement().visit(ctx.getChild(3));
                jsonPathElementSecond.prevJsonPathElement = this.prevJsonPathElement;
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

        try {
            if (doubleValue != null) {
                result = switch (compareType) {
                    case EQUALS -> Double.valueOf(leftValue).equals(doubleValue);
                    case NOT_EQUALS -> !Double.valueOf(leftValue).equals(doubleValue);
                    case LESS -> Double.parseDouble(leftValue) < doubleValue;
                    case LESS_OR_EQUALS -> Double.parseDouble(leftValue) <= doubleValue;
                    case GREATER -> Double.parseDouble(leftValue) > doubleValue;
                    case GREATER_OR_EQUALS -> Double.parseDouble(leftValue) >= doubleValue;
                };
            }
            if (longValue != null) {
                result = switch (compareType) {
                    case EQUALS -> Integer.valueOf(leftValue).equals(longValue);
                    case NOT_EQUALS -> !Integer.valueOf(leftValue).equals(longValue);
                    case LESS -> Integer.parseInt(leftValue) < longValue;
                    case LESS_OR_EQUALS -> Integer.parseInt(leftValue) <= longValue;
                    case GREATER -> Integer.parseInt(leftValue) > longValue;
                    case GREATER_OR_EQUALS -> Integer.parseInt(leftValue) >= longValue;
                };
            }
            if (stringValue != null) {
                result = switch (compareType) {
                    case EQUALS -> leftValue.equals(stringValue);
                    case NOT_EQUALS -> !leftValue.equals(stringValue);
                    default -> result;
                };
            }
        } catch (Exception e) {
/*            String message = null;
            if (longValue != null)
                message = String.format("Ошибка сравнения %s %s %d!", leftValue, compareType.str, longValue);
            else if (longValue != null)
                message = String.format("Ошибка сравнения %s %s %f!", leftValue, compareType.str, doubleValue);
            else if (stringValue != null)
                message = String.format("Ошибка сравнения %s %s %s!", leftValue, compareType.str, stringValue);
            throw new JsonPathException(message, jsonPath, prevJsonPathElement);*/
            return false;
        }
        return result;
    }
}
