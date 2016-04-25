package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.IReader;
import it.sevenbits.formatter.exception.ReaderException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Reader class.
 */
public class Reader implements IReader {
    private FileInputStream in;

    /**
     * Constructor.
     *
     * @param file - file variable.
     * @throws ReaderException
     */
    public Reader(final File file) throws ReaderException {
        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new ReaderException("File not found!", e);
        } catch (NullPointerException e) {
            throw new ReaderException("Null pointer!", e);
        }
    }

    /**
     * Read character from file.
     *
     * @return character.
     * @throws ReaderException
     */
    @Override
    public char read() throws ReaderException {
        try {
            return (char) in.read();
        } catch (IOException e) {
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
        try {
            return in.available() > 0;
        } catch (IOException e) {
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
        try {
            in.close();
        } catch (IOException e) {
            throw new ReaderException("Exception while closing closing reading stream!", e);
        }
    }
}
