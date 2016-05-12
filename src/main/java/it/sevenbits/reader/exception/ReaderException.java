package it.sevenbits.reader.exception;

/**
 * Reader class exception.
 */
public class ReaderException extends Exception {

    /**
     * Constructor.
     *
     * @param message - exception message.
     * @param e - caught exception.
     */
    public ReaderException(final String message, final Exception e) {
        super(message, e);
    }
}
