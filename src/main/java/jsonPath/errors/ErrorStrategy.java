package jsonPath.errors;

import org.antlr.v4.runtime.*;

public class ErrorStrategy extends DefaultErrorStrategy {

    @Override
    public void recover(Parser recognizer, RecognitionException e) {
        throw new JsonPathException(e.getMessage());
    }

    @Override
    public Token recoverInline(Parser recognizer)
            throws JsonPathException
    {
        throw new JsonPathException(new InputMismatchException(recognizer).getMessage());
    }
}
