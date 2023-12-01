package jsonPath;

import antlr.JsonPathParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

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

    public boolean filterRemoving;

    private List<JsonElement> forRemoved = new ArrayList<>();


    @Override
    public Filter visitFilter(JsonPathParser.FilterContext ctx) {
        if (ctx.MATCHTYPE() != null)
            modificator = Modificators.getModificators(ctx.MATCHTYPE().getText());
        condition = new Condition();
        condition.prevJsonPathElement = this.prevJsonPathElement;
        condition = condition.visit(ctx.condition());
        return this;
    }


    public void filter(JsonElement curJson) {

        forRemoved.clear();
        for (int i = 0; i < curJson.getAsJsonArray().size(); i++) {
            if (condition.filter(((JsonArray) curJson).get(i)) == 0)
                forRemoved.add(curJson.getAsJsonArray().get(i));
        }

        if (modificator == Modificators.NONMATCH) {
            if (forRemoved.size() == curJson.getAsJsonArray().size())
                forRemoved.clear();
            else {
                forRemoved.clear();
                forRemoved.addAll(curJson.getAsJsonArray().asList());
            }
        }
        if (modificator == Modificators.ALLMATCH) {
            if (!forRemoved.isEmpty()) {
                forRemoved.clear();
                forRemoved.addAll(curJson.getAsJsonArray().asList());
            }
        }

        if (filterRemoving || forRemoved.size() == curJson.getAsJsonArray().size()) {
            for (JsonElement elemRemove : forRemoved)
                curJson.getAsJsonArray().remove(elemRemove);
        }
    }
}
