package it.sevenbits.writer;

import it.sevenbits.reader.Reader;
import it.sevenbits.reader.exception.ReaderException;
import it.sevenbits.writer.exception.WriterException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.File;

public class WriterTest {
    private Writer writer;

    @Test
    public void testWrite() throws WriterException, ReaderException {
        File testFile = new File(WriterTest.class.getResource("writer-test1.txt").getFile());
        writer = new Writer(testFile);
        Reader reader = new Reader(testFile);
        writer.write('1');
        assertEquals('1', reader.read());
    }

    @Test (expected = WriterException.class)
    public void testWriteIOException() throws WriterException {
        File testFile = new File(WriterTest.class.getResource("writer-test1.txt").getFile());
        writer = new Writer(testFile);
        writer.close();
        writer.write('1');
    }

    @Test (expected = WriterException.class)
    public void testConstructorFileNotFound() throws WriterException {
        File testFile = new File(WriterTest.class.getResource("").getFile());
        writer = new Writer(testFile);
    }

    @Test (expected = WriterException.class)
    public void testConstructorNullPointer() throws WriterException {
        writer = new Writer(null);
    }
}
