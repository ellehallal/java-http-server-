package httpserver.http.request;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RequestReaderTest {

    @Test
    void returnsInput() {
        var stringReader = new StringReader("GET / HTTP/1.1");
        var input = new BufferedReader(stringReader);

        var request = RequestReader.read(input);

        assertEquals("GET / HTTP/1.1", request);
    }
}
