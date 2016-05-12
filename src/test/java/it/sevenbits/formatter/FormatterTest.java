package it.sevenbits.formatter;

import it.sevenbits.formatter.exception.FormatterException;
import it.sevenbits.reader.Reader;
import it.sevenbits.reader.exception.ReaderException;
import it.sevenbits.writer.Writer;
import it.sevenbits.writer.exception.WriterException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class FormatterTest {
    private final int tabSize = 2;
    private Formatter formatter;

    @Before
    public void setup() {
        formatter = new Formatter(tabSize);
    }

    @Test
    public void testFormat() throws ReaderException, WriterException, FormatterException {
        File inputFile = new File(FormatterTest.class.getResource("formatter-test1-in.txt").getFile());
        File outputFile = new File(FormatterTest.class.getResource("formatter-test1-out.txt").getFile());

        Reader reader = new Reader(inputFile);
        Writer writer = new Writer(outputFile);

        formatter.format(reader, writer);
    }

    @Test (expected = FormatterException.class)
    public void testFormatException1() throws ReaderException, WriterException, FormatterException {
        File inputFile = new File(FormatterTest.class.getResource("formatter-test2-in.txt").getFile());
        File outputFile = new File(FormatterTest.class.getResource("formatter-test1-out.txt").getFile());

        Reader reader = new Reader(inputFile);
        Writer writer = new Writer(outputFile);

        formatter.format(reader, writer);
    }

    @Test (expected = FormatterException.class)
    public void testFormatException2() throws ReaderException, WriterException, FormatterException {
        File inputFile = new File(FormatterTest.class.getResource("formatter-test3-in.txt").getFile());
        File outputFile = new File(FormatterTest.class.getResource("formatter-test1-out.txt").getFile());

        Reader reader = new Reader(inputFile);
        Writer writer = new Writer(outputFile);

        formatter.format(reader, writer);
    }

    @Test (expected = FormatterException.class)
    public void testFormatException() throws ReaderException, WriterException, FormatterException {
        Reader reader = null;
        Writer writer = null;

        formatter.format(reader, writer);
    }
}
