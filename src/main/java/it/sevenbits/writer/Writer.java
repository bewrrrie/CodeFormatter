package it.sevenbits.writer;

import it.sevenbits.Closeable;
import it.sevenbits.writer.exception.WriterException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Writer class.
 */
public class Writer implements IWriter, Closeable {
    private Logger logger;
    private FileOutputStream out;

    /**
     * Constructor.
     *
     * @param file - file variable.
     * @throws WriterException
     */
    public Writer(final File file) throws WriterException {
        logger = LoggerFactory.getLogger(it.sevenbits.writer.Writer.class);

        logger.info("creating writer object...");
        try {
            out = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            logger.error("file not found!");
            throw new WriterException("File not found!", e);
        } catch (NullPointerException e) {
            logger.error("got null!");
            throw new WriterException("Null pointer!", e);
        }
        logger.info("writer object created!");
    }

    /**
     * Write character to file.
     *
     * @param c - input character.
     * @throws WriterException
     */
    @Override
    public void write(final char c) throws WriterException {
        logger.info("writing character to file...");
        try {
            out.write(c);
        } catch (IOException e) {
            logger.error("got error while writing character to file!");
            throw new WriterException("Exception while writing file!", e);
        }
    }

    /**
     * Close writing stream.
     *
     * @throws WriterException
     */
    @Override
    public void close() throws WriterException {
        logger.info("closing writing stream...");
        try {
            out.close();
        } catch (IOException e) {
            logger.error("got error while closing writing stream!");
            throw new WriterException("Exception while closing writing stream!", e);
        }
        logger.info("writing stream closed successfully!");
    }
}
