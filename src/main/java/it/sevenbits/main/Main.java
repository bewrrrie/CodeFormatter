package it.sevenbits.main;

import it.sevenbits.formatter.Formatter;
import it.sevenbits.formatter.exception.FormatterException;
import it.sevenbits.reader.Reader;
import it.sevenbits.reader.exception.ReaderException;
import it.sevenbits.writer.Writer;
import it.sevenbits.writer.exception.WriterException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.File;

/**
 * Main class.
 */
final class Main {

    /**
     * Private constructor.
     */
    private Main() {}

    private static final int TAB_SIZE = 2;

    /**
     * Main method.
     *
     * @param args - array of arguments.
     */
    public static void main(final String[] args) {
        Logger logger = LoggerFactory.getLogger(it.sevenbits.main.Main.class);

        String sourceFileDir = args[0];
        String outputFileDir = sourceFileDir.replace(sourceFileDir.split("/")[sourceFileDir.split("/").length - 1], "output.txt");

        File sourceFile = new File(sourceFileDir);
        File outputFile = new File(outputFileDir);

        try {
            Reader sourceFileReader = new Reader(sourceFile);
            Writer sourceFileWriter = new Writer(outputFile);
            Formatter formatter = new Formatter(TAB_SIZE);

            formatter.format(sourceFileReader, sourceFileWriter);
            sourceFileReader.close();
            sourceFileReader.close();
        } catch (FormatterException e) {
            logger.error("Exception while formatting!");
        } catch (ReaderException e) {
            logger.error("Exception in reader!");
        } catch (WriterException e) {
            logger.error("Exception in writer!");
        }
    }
}
