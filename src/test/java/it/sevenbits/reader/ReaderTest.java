package it.sevenbits.reader;

import it.sevenbits.reader.exception.ReaderException;
import it.sevenbits.writer.Writer;
import it.sevenbits.writer.exception.WriterException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.File;

public class ReaderTest {
    private Reader reader;

    @Test(expected = ReaderException.class)
    public void testReadIOException() throws ReaderException {
        File testFile = new File(ReaderTest.class.getResource("reader-test1.txt").getFile());
        reader = new Reader(testFile);
        reader.close();
        reader.read();
    }

    @Test (expected = ReaderException.class)
    public void testConstructorFileNotFound() throws ReaderException {
        File testFile = new File(ReaderTest.class.getResource("").getFile());
        reader = new Reader(testFile);
    }

    @Test (expected = ReaderException.class)
    public void testConstructorNullPointer() throws ReaderException {
        reader = new Reader(null);
    }

    @Test
    public void testIsAvailable() throws ReaderException, WriterException {
        File testFile = new File(ReaderTest.class.getResource("reader-test1.txt").getFile());
        reader = new Reader(testFile);
        Writer writer = new Writer(testFile);
        writer.write('1');
        assertEquals(true, reader.isAvailable());
    }

    @Test (expected = ReaderException.class)
    public void testIsAvailableIOException() throws ReaderException {
        File testFile = new File(ReaderTest.class.getResource("reader-test1.txt").getFile());
        reader = new Reader(testFile);
        reader.close();
        reader.isAvailable();
    }
}
