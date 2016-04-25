package it.sevenbits.formatter;

import it.sevenbits.formatter.exception.WriterException;

/**
 * Writer interface.
 */
public interface IWriter {

    /**
     * Write character to file.
     *
     * @param c - input character.
     * @throws WriterException
     */
    void write(final char c) throws WriterException;

    /**
     * Close writing stream.
     *
     * @throws WriterException
     */
    void close() throws WriterException;
}
