package it.sevenbits.formatter.main;

import it.sevenbits.formatter.implementation.Formatter;
import it.sevenbits.formatter.implementation.Reader;
import it.sevenbits.formatter.implementation.Writer;

import java.io.File;

/**
 * Main class.
 */
final class Main {

    /**
     * Private constructor.
     */
    private Main() {}

    private static final int TAB_SIZE = 4;

    private static final String SOURCE_FILE_DIR = Main.class.getResource("/sample.txt").getFile();
    private static final String OUTPUT_FILE_DIR = Main.class.getResource("/output.txt").getFile();

    private static final File SOURCE_FILE = new File(SOURCE_FILE_DIR);
    private static final File OUTPUT_FILE = new File(OUTPUT_FILE_DIR);

    /**
     * Main method.
     *
     * @param args - array of arguments.
     */
    public static void main(final String[] args) {
        System.out.println("source file: " + SOURCE_FILE_DIR + "\noutput file: " + OUTPUT_FILE_DIR);

        try {
            Reader reader = new Reader(SOURCE_FILE);
            Writer writer = new Writer(OUTPUT_FILE);
            Formatter formatter = new Formatter(reader, writer);

            formatter.format(TAB_SIZE);
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}
