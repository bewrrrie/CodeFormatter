package it.sevenbits.formatter.exception;

/**
 * Writer class exception.
 */
public class WriterException extends Exception {

    /**
     * Constructor.
     *
     * @param message - exception message.
     * @param e - caught exception.
     */
    public WriterException(final String message, final Exception e) {
        super(message, e);
    }
}
