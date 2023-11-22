package jsonPath;

import antlr.JsonPathParser;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class Condition extends BaseModel<Condition> {

    private List<BaseModel> expressionsAndConditions;

    private List<LogicExpression> logicExpressions;

    private enum LogicExpression {
        AND(BaseModel.getLiteralValue(JsonPathParser.AND), (l, r) -> l & r),
        OR(BaseModel.getLiteralValue(JsonPathParser.OR), (l, r) -> l | r);
        private final String str;

        private final IntBinaryOperator func;
        LogicExpression(String str, IntBinaryOperator func) {
            this.str = str;
            this.func = func;
        }
        public static LogicExpression getLogicExpression(String str) {
            for (LogicExpression cur : values()) {
                if (cur.str.equals(str))
                    return cur;
            }
            return null;
        }
    }

    @Override
    public Condition visitCondition(JsonPathParser.ConditionContext ctx) {

        expressionsAndConditions = new ArrayList<>();
        logicExpressions = new ArrayList<>();

        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof JsonPathParser.PriorityContext) {
                Condition condition = new Condition();
                condition.prevJsonPathElement = this.prevJsonPathElement;
                condition.visit(((JsonPathParser.PriorityContext) ctx.getChild(i)).condition());
                expressionsAndConditions.add(condition);
            } else if (ctx.getChild(i) instanceof JsonPathParser.ExprContext) {
                Expression expression = new Expression();
                expression.prevJsonPathElement = this.prevJsonPathElement;
                expression.visit(ctx.getChild(i));
                expressionsAndConditions.add(expression);
            } else
                logicExpressions.add(LogicExpression.getLogicExpression(ctx.getChild(i).getText()));
        }

        return this;
    }

    public Integer filter(JsonElement curJson) {
        Integer result = 0;

        for (BaseModel expressionsAndCondition : expressionsAndConditions) {
            result = result << 1;
            if (expressionsAndCondition instanceof Expression)
                result |= ((Expression) expressionsAndCondition).compare(curJson) ? 1 : 0;
            else if (expressionsAndCondition instanceof Condition)
                result |= ((Condition) expressionsAndCondition).filter(curJson);
        }

        for (LogicExpression cur : LogicExpression.values())
            result = runLogicOperator(result, cur);

        return result;
    }

     private Integer runLogicOperator(Integer startBit, LogicExpression curLogicExpression) {
        int tmp = 0;

        if (!logicExpressions.contains(curLogicExpression))
            return startBit;

        for (int i = 0; i < logicExpressions.size(); i++) {
             if (logicExpressions.get(i) == curLogicExpression)
                 tmp |= curLogicExpression.func.applyAsInt((startBit >> logicExpressions.size() - i) & 1,
                         (startBit >> logicExpressions.size() - (i + 1)) & 1);
             else if (logicExpressions.get(i).ordinal() == curLogicExpression.ordinal() + 1)
                 tmp <<= 1;
         }

        return tmp;
     }
}
