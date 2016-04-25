package it.sevenbits.formatter.exception;

/**
 * Formatter exception class.
 */
public class FormatterException extends Exception {

    /**
     * Constructor.
     *
     * @param message - exception message.
     * @param e - caught exception.
     */
    public FormatterException(final String message, final Exception e) {
        super(message, e);
    }
}
