package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.exception.ReaderException;
import org.junit.Test;

import java.io.File;

public class ReaderTest {
    private Reader reader;

    @Test (expected = ReaderException.class)
    public void testReadIOExc() throws ReaderException {
        reader = new Reader(new File(ReaderTest.class.getResource("/test1.txt").getFile()));
        reader.close();
        reader.read();
    }

    @Test (expected = ReaderException.class)
    public void testNullPointer() throws ReaderException {
        reader = new Reader(new File(ReaderTest.class.getResource("").getFile()));
    }

    @Test (expected = ReaderException.class)
    public void testIsAvailable() throws ReaderException {
        reader = new Reader(null);
        reader.isAvailable();
    }

    @Test (expected = ReaderException.class)
    public void testIsAvailableException() throws ReaderException {
        reader = new Reader(new File(ReaderTest.class.getResource("/test1.txt").getFile()));
        reader.close();
        reader.isAvailable();
    }
}
