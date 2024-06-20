
package yusudoku.logical.checkers;

/**
 *
 * @author nathan
 */
public class CheckerException extends Exception {

    /**
     * Creates a new instance of <code>CheckerException</code> without detail
     * message.
     */
    public CheckerException() {
    }

    /**
     * Constructs an instance of <code>CheckerException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CheckerException(String msg) {
        super(msg);
    }
}
