package jsonPath;

import antlr.JsonPathParser;
import com.google.gson.JsonElement;

public class Filter extends BaseModel<Filter> {
    private Modificators modificator = null;

    private enum Modificators {
        ALLMATCH(BaseModel.getLiteralValue(JsonPathParser.ALLMATCH)),
        NONMATCH(BaseModel.getLiteralValue(JsonPathParser.NONMATCH));
        private String str;
        Modificators(String str) {this.str = str;}
        public static Modificators getModificators(String str) {
            for (Modificators cur : values()) {
                if (cur.str.equals(str))
                    return cur;
            }
            return null;
        }
    }
    private Condition condition;

    @Override
    public Filter visitFilter(JsonPathParser.FilterContext ctx) {
        if (ctx.MATCHTYPE() != null)
            modificator = Modificators.getModificators(ctx.MATCHTYPE().getText());
        condition = new Condition().visit(ctx.condition());
        condition.prevJsonPathElement = this.prevJsonPathElement;
        return this;
    }


    public Integer filter(JsonElement curJson) {
        Integer bit = condition.filter(curJson);

        if (modificator == Modificators.NONMATCH)
            bit = ((bit | 0) == 0) ? -1 : 0;
        else if (modificator == Modificators.ALLMATCH)
            bit = (~(bit & -1) == 0) ? 0 : -1;
        return bit;
    }
}
