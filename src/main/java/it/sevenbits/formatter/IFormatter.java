package it.sevenbits.formatter;

import it.sevenbits.formatter.exception.FormatterException;

/**
 * Formatter interface.
 */
public interface IFormatter {

    /**
     * Format code.
     *
     * @param tabSize - size of one tabulation.
     * @throws FormatterException
     */
    void format(final int tabSize) throws FormatterException;
}
