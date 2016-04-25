package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.IFormatter;
import it.sevenbits.formatter.exception.FormatterException;

/**
 * Code formatter.
 */
public class Formatter implements IFormatter {
    private Reader reader;
    private Writer writer;

    /**
     * Constructor.
     *
     * @param reader - reader variable.
     * @param writer - writer variable.
     */
    public Formatter(final Reader reader, final Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Format code.
     *
     * @throws FormatterException
     */
    @Override
    public void format(final int tabSize) throws FormatterException {
        try {

            int braces = 0;
            int parenthesis = 0;
            int tabLevel = 0;

            char current = ' ';
            while (reader.isAvailable()) {
                if (braces < 0) {
                    throw new FormatterException("Negative braces quantity!", new Exception());
                }
                if (parenthesis < 0) {
                    throw new FormatterException("Negative parenthesis quantity!", new Exception());
                }
                if (tabLevel < 0) {
                    throw new FormatterException("Negative tab level!", new Exception());
                }

                char previous = current;
                current = reader.read();
                switch (current) {
                    case '{':
                        for (int i = 0; i < tabLevel * tabSize; i++) {
                            writer.write(' ');
                        }
                        writer.write(current);
                        writer.write('\n');
                        current = '\n';
                        braces++;
                        tabLevel++;

                        break;

                    case '}':
                        braces--;
                        tabLevel--;
                        if (previous != '\n') {
                            writer.write('\n');
                        }
                        for (int i = 0; i < tabLevel * tabSize; i++) {
                            writer.write(' ');
                        }
                        writer.write(current);
                        writer.write('\n');
                        current = '\n';
                        break;

                    case ';':
                        writer.write(current);
                        writer.write('\n');
                        current = '\n';
                        break;

                    case '(':
                        if (previous == '\n') {
                            for (int i = 0; i < tabLevel * tabSize; i++) {
                                writer.write(' ');
                            }
                        }
                        parenthesis++;
                        writer.write(current);
                        break;

                    case ')':
                        if (previous == '\n') {
                            for (int i = 0; i < tabLevel * tabSize; i++) {
                                writer.write(' ');
                            }
                        }
                        parenthesis--;
                        writer.write(current);
                        break;

                    default:
                        if (previous == '\n') {
                            for (int i = 0; i < tabLevel * tabSize; i++) {
                                writer.write(' ');
                            }
                        }
                        writer.write(current);
                        break;
                }
            }

            if (braces > 0) {
                throw new FormatterException("Some of braces are not closed!", new Exception());
            }
            if (parenthesis > 0) {
                throw new FormatterException("Some of parenthesis are not closed!", new Exception());
            }

        } catch (Exception e) {
            throw new FormatterException("Exception while formatting code!", e);
        }
    }
}
