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

    private TypeValueForCompare typeValueForCompare;

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
                typeValueForCompare = new StringValue("");

            } else {
                try {
                    typeValueForCompare = new LongValue(Long.valueOf(ctx.getChild(2).getText()));
                } catch (Exception eLong) {
                    try {
                        typeValueForCompare = new DoubleValue(Double.valueOf(ctx.getChild(2).getText()));
                    } catch (Exception eDouble) {
                        String rightValue = ctx.getChild(2).getText();
                        typeValueForCompare = new StringValue(rightValue);

                        if (rightValue.equals("null"))
                            typeValueForCompare = new NullValue(rightValue);
                        else if (rightValue.equals("empty"))
                            typeValueForCompare = new EmptyValue(rightValue);
                        else {
                            functionForCompare = FunctionForCompare.getFunctionForCompare(rightValue);
                            if (functionForCompare == null) {
                                rightValue = rightValue.substring(1, ctx.getChild(2).getText().length() - 1);
                                typeValueForCompare = new StringValue(rightValue);
                            }
                        }
                    }
                }
            }
        }
        return this;
    }

    public boolean compare(JsonElement curJson) {
        try {
            return typeValueForCompare.runCheck(jsonPathElement.read(curJson));
        } catch (Exception e) {
            return false;
        }
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

    private abstract static class TypeValueForCompare<T>{

        protected T rightValue;

        TypeValueForCompare(T rightValue) {
            this.rightValue = rightValue;
        }
        abstract boolean runCheck(JsonElement leftValue);
    }

    class DoubleValue extends TypeValueForCompare<Double> {

        public DoubleValue(Double rightValue) {
            super(rightValue);
        }
        @Override
        boolean runCheck(JsonElement leftValue) {
            boolean result = false;

            String strLeftValue = convertJsonToString(leftValue);

            switch (compareType) {
                case EQUALS : result = Double.valueOf(strLeftValue).equals(rightValue); break;
                case NOT_EQUALS : result = !Double.valueOf(strLeftValue).equals(rightValue); break;
                case LESS : result = Double.parseDouble(strLeftValue) < rightValue; break;
                case LESS_OR_EQUALS : result = Double.parseDouble(strLeftValue) <= rightValue; break;
                case GREATER : result = Double.parseDouble(strLeftValue) > rightValue; break;
                case GREATER_OR_EQUALS : result = Double.parseDouble(strLeftValue) >= rightValue; break;

            }

            return result;
        }
    }

    class LongValue extends TypeValueForCompare<Long> {

        public LongValue(Long rightValue) {
            super(rightValue);
        }

        @Override
        boolean runCheck(JsonElement leftValue) {
            boolean result = false;

            String strLeftValue = convertJsonToString(leftValue);

            switch (compareType) {
                case EQUALS : result = Long.valueOf(strLeftValue).equals(rightValue); break;
                case NOT_EQUALS : result = !Long.valueOf(strLeftValue).equals(rightValue); break;
                case LESS : result = Long.parseLong(strLeftValue) < rightValue; break;
                case LESS_OR_EQUALS : result = Long.parseLong(strLeftValue) <= rightValue; break;
                case GREATER : result = Long.parseLong(strLeftValue) > rightValue; break;
                case GREATER_OR_EQUALS : result = Long.parseLong(strLeftValue) >= rightValue; break;
            }

            return result;
        }
    }

    class StringValue extends TypeValueForCompare<String> {

        public StringValue(String rightValue) {
            super(rightValue);
        }
        @Override
        boolean runCheck(JsonElement leftValue) {
            boolean result = false;

            if (back != null)
                rightValue = runBack();

            String strLeftValue = (!leftValue.isJsonNull()) ? convertJsonToString(leftValue) : "";

            switch (compareType) {
                case EQUALS : result = (functionForCompare != null) ? functionForCompare.func.test(strLeftValue, rightValue) : strLeftValue.equals(rightValue); break;
                case NOT_EQUALS : result = (functionForCompare != null) ? !functionForCompare.func.test(strLeftValue, rightValue) : !strLeftValue.equals(rightValue); break;
            }

            return result;
        }
    }

    class NullValue extends TypeValueForCompare<String> {


        public NullValue(String rightValue) {
            super(rightValue);
        }
        @Override
        boolean runCheck(JsonElement leftValue) {
            boolean result = false;

            switch (compareType) {
                case EQUALS : result = leftValue.isJsonNull(); break;
                case NOT_EQUALS : result = !leftValue.isJsonNull(); break;
            }
            return result;
        }
    }

    class EmptyValue extends TypeValueForCompare<String> {

        public EmptyValue(String rightValue) {
            super(rightValue);
        }
        @Override
        boolean runCheck(JsonElement leftValue) {
            boolean result = false;

            switch (compareType) {
                case EQUALS :
                    if (leftValue.isJsonArray())
                        result = leftValue.getAsJsonArray().isEmpty();
                    else if (leftValue.isJsonObject())
                        result = leftValue.getAsJsonObject().isEmpty();
                    break;
                case NOT_EQUALS :
                    if (leftValue.isJsonArray())
                        result = !leftValue.getAsJsonArray().isEmpty();
                    else if (leftValue.isJsonObject())
                        result = !leftValue.getAsJsonObject().isEmpty();
                    break;
            }

            return result;
        }
    }
}
