package it.sevenbits.reader;

import it.sevenbits.Closeable;
import it.sevenbits.reader.exception.ReaderException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reader class.
 */
public class Reader implements IReader, Closeable {
    private Logger logger;
    private FileInputStream in;

    /**
     * Constructor.
     *
     * @param file - file variable.
     * @throws ReaderException
     */
    public Reader(final File file) throws ReaderException {
        logger = LoggerFactory.getLogger(it.sevenbits.reader.Reader.class);

        logger.info("creating reader object...");
        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            logger.error("file not found!");
            throw new ReaderException("File not found!", e);
        } catch (NullPointerException e) {
            logger.error("got null!");
            throw new ReaderException("Null pointer!", e);
        }
        logger.info("reader object created!");
    }

    /**
     * Read character from file.
     *
     * @return character.
     * @throws ReaderException
     */
    @Override
    public char read() throws ReaderException {
        logger.info("reading character from file...");
        try {
            return (char) in.read();
        } catch (IOException e) {
            logger.error("got error while reading character from file!");
            throw new ReaderException("Exception while reading file!", e);
        }
    }

    /**
     * Is available to read.
     *
     * @return true - available, false - not.
     * @throws ReaderException
     */
    @Override
    public boolean isAvailable() throws ReaderException {
        logger.info("checking if file still available for reading...");
        try {
            return in.available() > 0;
        } catch (IOException e) {
            logger.error("got error while checking file for available bytes!");
            throw new ReaderException("Exception while checking available bytes to read!", e);
        }
    }

    /**
     * Close reading stream.
     *
     * @throws ReaderException
     */
    @Override
    public void close() throws ReaderException {
        logger.info("closing reading stream...");
        try {
            in.close();
        } catch (IOException e) {
            logger.error("got error while closing reading stream!");
            throw new ReaderException("Exception while closing closing reading stream!", e);
        }
        logger.info("reading stream closed successfully!");
    }
}
