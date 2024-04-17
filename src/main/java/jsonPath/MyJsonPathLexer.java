package jsonPath;

import antlr.JsonPathLexer;
import jsonPath.errors.JsonPathException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.LexerNoViableAltException;
import org.antlr.v4.runtime.misc.Interval;

public class MyJsonPathLexer extends JsonPathLexer {

    public MyJsonPathLexer(CharStream input) { super(input); }

    @Override
    public void notifyListeners(LexerNoViableAltException e) {
        String text = this._input.getText(Interval.of(this._tokenStartCharIndex, this._input.index()));
        String msg = "Syntax error: token recognition error at: line " + this.getLine() + ":" + this._tokenStartCharIndex + " '" + this.getErrorDisplay(text) + "'";
        throw new JsonPathException(msg);
    }
}
