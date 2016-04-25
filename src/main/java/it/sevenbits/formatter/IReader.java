package it.sevenbits.formatter;

import it.sevenbits.formatter.exception.ReaderException;

/**
 * Reader interface.
 */
public interface IReader {

    /**
     * Read character from file.
     *
     * @return character.
     * @throws ReaderException
     */
    char read() throws ReaderException;

    /**
     * Is available to read.
     *
     * @return true - available, false - not.
     * @throws ReaderException
     */
    boolean isAvailable() throws ReaderException;

    /**
     * Close reading stream.
     *
     * @throws ReaderException
     */
    void close() throws ReaderException;
}
