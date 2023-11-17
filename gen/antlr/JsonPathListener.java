// Generated from C:/Users/NIKITA-PC/Desktop/jsonPath_v3/src/main/java/antlr/JsonPath.g4 by ANTLR 4.13.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JsonPathParser}.
 */
public interface JsonPathListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JsonPathParser#jsonPath}.
	 * @param ctx the parse tree
	 */
	void enterJsonPath(JsonPathParser.JsonPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsonPathParser#jsonPath}.
	 * @param ctx the parse tree
	 */
	void exitJsonPath(JsonPathParser.JsonPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link JsonPathParser#jsonPathElement}.
	 * @param ctx the parse tree
	 */
	void enterJsonPathElement(JsonPathParser.JsonPathElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsonPathParser#jsonPathElement}.
	 * @param ctx the parse tree
	 */
	void exitJsonPathElement(JsonPathParser.JsonPathElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JsonPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFilter(JsonPathParser.FilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsonPathParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFilter(JsonPathParser.FilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JsonPathParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(JsonPathParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsonPathParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(JsonPathParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JsonPathParser#priority}.
	 * @param ctx the parse tree
	 */
	void enterPriority(JsonPathParser.PriorityContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsonPathParser#priority}.
	 * @param ctx the parse tree
	 */
	void exitPriority(JsonPathParser.PriorityContext ctx);
	/**
	 * Enter a parse tree produced by {@link JsonPathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(JsonPathParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsonPathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(JsonPathParser.ExprContext ctx);
}