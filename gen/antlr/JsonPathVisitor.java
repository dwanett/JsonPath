// Generated from C:/Users/NIKITA-PC/Desktop/jsonPath_v3/src/main/java/antlr/JsonPath.g4 by ANTLR 4.13.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JsonPathParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JsonPathVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JsonPathParser#jsonPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonPath(JsonPathParser.JsonPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonPathParser#jsonPathElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonPathElement(JsonPathParser.JsonPathElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonPathParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter(JsonPathParser.FilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonPathParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(JsonPathParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonPathParser#priority}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPriority(JsonPathParser.PriorityContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonPathParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(JsonPathParser.ExprContext ctx);
}