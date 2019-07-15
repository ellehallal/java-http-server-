package httpserver.server;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleWriterTest {

    @Test
    void printsHello() {
        var outputStream = new ByteArrayOutputStream();
        var printStream = new PrintStream(outputStream);
        var oldPrintStream = System.out;
        System.setOut(printStream);

        new ConsoleWriter().println("Hello");

        System.out.flush();
        System.setOut(oldPrintStream);

        assertEquals("Hello\n", outputStream.toString());
    }
}
