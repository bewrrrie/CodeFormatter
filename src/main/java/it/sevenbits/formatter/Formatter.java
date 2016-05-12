package it.sevenbits.formatter;

import it.sevenbits.formatter.exception.FormatterException;
import it.sevenbits.reader.IReader;
import it.sevenbits.writer.IWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Code formatter.
 */
public class Formatter implements IFormatter {
    private Logger logger;
    private int tabSize;

    /**
     * Constructor.
     *
     * @param tabSize - writer variable.
     */
    public Formatter(final int tabSize) {
        logger = LoggerFactory.getLogger(it.sevenbits.formatter.Formatter.class);

        logger.info("creating formatter object...");
        this.tabSize = tabSize;
        logger.info("formatter object created!");
    }

    /**
     * Format code.
     *
     * @param writer - writer object.
     * @param reader - reader object.
     * @throws FormatterException
     */
    @Override
    public void format(final IReader reader, final IWriter writer) throws FormatterException {
        logger.info("formatting file...");
        try {
            int braces = 0;
            int parenthesis = 0;
            int tabLevel = 0;

            char current = ' ';
            while (reader.isAvailable()) {
                if (braces < 0) {
                    logger.error("braces quantity is negative!");
                    throw new FormatterException("Negative braces quantity!", new Exception());
                }
                if (parenthesis < 0) {
                    logger.error("parenthesis quantity is negative!");
                    throw new FormatterException("Negative parenthesis quantity!", new Exception());
                }
                if (tabLevel < 0) {
                    tabLevel = 0;
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
                logger.error("wrong number number of braces!");
                throw new FormatterException("Some of braces are not closed!", new Exception());
            }
            if (parenthesis > 0) {
                logger.error("wrong number number of parenthesis!");
                throw new FormatterException("Some of parenthesis are not closed!", new Exception());
            }

        } catch (Exception e) {
            logger.error("got error while formatting file!");
            throw new FormatterException("Exception while formatting code!", e);
        }
        logger.info("formatting file finished successfully!");
    }
}
