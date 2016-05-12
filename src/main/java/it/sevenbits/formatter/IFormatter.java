package it.sevenbits.formatter;

import it.sevenbits.formatter.exception.FormatterException;
import it.sevenbits.reader.IReader;
import it.sevenbits.writer.IWriter;

/**
 * Formatter interface.
 */
interface IFormatter {

    /**
     * Format code.
     *
     * @param writer - writer object.
     * @param reader - reader object.
     * @throws FormatterException
     */
    void format(final IReader reader, final IWriter writer) throws FormatterException;
}
