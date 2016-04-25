package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.exception.FormatterException;
import it.sevenbits.formatter.exception.ReaderException;
import it.sevenbits.formatter.exception.WriterException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class FormatterTest {

    @Before
    public void setUp() {

    }

    @Test
    public void testFormat() throws WriterException, ReaderException, FormatterException {
        Reader reader = new Reader(new File(FormatterTest.class.getResource("/test3-in.txt").toString().replace("file:", "")));
        Writer writer = new Writer(new File(FormatterTest.class.getResource("/test3-out.txt").toString().replace("file:", "")));

        Formatter formatter = new Formatter(reader, writer);
        formatter.format(4);

        reader.close();
        reader = new Reader(new File(FormatterTest.class.getResource("/test3-in.txt").toString().replace("file:", "")));
        reader.close();
        writer.close();
    }
}