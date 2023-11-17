package jsonPath;

import antlr.JsonPathParser;
import com.google.gson.JsonElement;

public class Condition extends BaseModel<Condition> {

    private Expression expression;

    private Condition condition;

    private LogicExpression logicExpression;

    private enum LogicExpression {
        AND(BaseModel.getLiteralValue(JsonPathParser.AND)),
        OR(BaseModel.getLiteralValue(JsonPathParser.OR));
        private String str;
        LogicExpression(String str) {this.str = str;}
        public static LogicExpression getLogicExpression(String str) {
            for (LogicExpression cur : values()) {
                if (cur.str.equals(str))
                    return cur;
            }
            return null;
        }
    }

    private Condition conditionLeft;


    @Override
    public Condition visitCondition(JsonPathParser.ConditionContext ctx) {
        //expression = new Expression().visit(ctx.expr());

        if (ctx.getChildCount() > 1) {
           //logicExpression = LogicExpression.getLogicExpression(ctx.LOGICEXPR().getText());

            //if (ctx.condition().size() > 1) {
            //    condition =  new Condition().visit(ctx.condition().get(1));
            //    conditionLeft = new Condition().visit(ctx.condition().get(0));
            //    conditionLeft.prevJsonPathElement = this.prevJsonPathElement;
            //} else
            //    condition = new Condition().visit(ctx.condition().get(0));
            //condition.prevJsonPathElement = this.prevJsonPathElement;
        }

        return this;
    }

    public Integer filter(JsonElement curJson) {
        Integer result = 0;

        if (expression != null)
            result = expression.compare(curJson) ? 1 : 0;
        if (conditionLeft != null) {
            if (logicExpression == LogicExpression.AND)
                result &= conditionLeft.filter(curJson);
            if (logicExpression == LogicExpression.OR)
                result |= conditionLeft.filter(curJson);
        }
        if (condition != null) {
            if (logicExpression == LogicExpression.AND)
                result &= condition.expression.compare(curJson) ? 1 : 0;
            if (logicExpression == LogicExpression.OR)
                result |= condition.filter(curJson);
        }
        return result;
    }
}
