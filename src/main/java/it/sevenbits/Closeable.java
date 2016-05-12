package it.sevenbits;

import it.sevenbits.reader.exception.ReaderException;
import it.sevenbits.writer.exception.WriterException;

/**
 * Closeable stream interface.
 */
public interface Closeable {

    /**
     * Close stream.
     *
     * @throws WriterException
     */
    void close() throws WriterException, ReaderException;
}
