package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.exception.WriterException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class WriterTest {
    private FileInputStream in;
    private Writer writer;

    @Test
    public void testWrite() throws IOException, WriterException {
        writer = new Writer(new File(ReaderTest.class.getResource("/test2.txt").getFile()));
        writer.write('h');
        in = new FileInputStream(new File(ReaderTest.class.getResource("/test2.txt").getFile()));
        writer.close();
        assertEquals('h', in.read());
    }

    @Test (expected = WriterException.class)
    public void testConstructorNotFound() throws WriterException {
        writer = new Writer(new File("/test1.txt"));
    }

    @Test (expected = WriterException.class)
    public void testConstructorNull() throws WriterException {
        writer = new Writer(null);
    }

    @Test (expected = WriterException.class)
    public void testWriteException() throws IOException, WriterException {
        writer = new Writer(new File(ReaderTest.class.getResource("/test2.txt").getFile()));
        writer.close();
        writer.write('h');
    }

}
