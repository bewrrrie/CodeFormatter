package it.sevenbits.reader;

import it.sevenbits.reader.exception.ReaderException;

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
}
