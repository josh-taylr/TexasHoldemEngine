package jt.poker.texasholdemengine;

/**
 * Created by Josh on 29/02/16.
 */
public class IncomparableCardException extends RuntimeException {
    public IncomparableCardException() {
        super();
    }

    public IncomparableCardException(String message) {
        super(message);
    }

    public IncomparableCardException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncomparableCardException(Throwable cause) {
        super(cause);
    }
}
