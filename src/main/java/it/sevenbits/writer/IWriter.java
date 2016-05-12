package it.sevenbits.writer;

import it.sevenbits.writer.exception.WriterException;

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
}
