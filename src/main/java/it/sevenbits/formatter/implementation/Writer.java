package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.IWriter;
import it.sevenbits.formatter.exception.WriterException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Writer class.
 */
public class Writer implements IWriter {
    private FileOutputStream out;

    /**
     * Constructor.
     *
     * @param file - file variable.
     * @throws WriterException
     */
    public Writer(final File file) throws WriterException {
        try {
            out = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new WriterException("File not found!", e);
        } catch (NullPointerException e) {
            throw new WriterException("Null pointer!", e);
        }
    }

    /**
     * Write character to file.
     *
     * @param c - input character.
     * @throws WriterException
     */
    @Override
    public void write(final char c) throws WriterException {
        try {
            out.write(c);
        } catch (IOException e) {
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
        try {
            out.close();
        } catch (IOException e) {
            throw new WriterException("Exception while closing writing stream!", e);
        }
    }
}
