package httpserver.http.request;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RequestReaderTest {

    @Test
    void returnsInputWithRequestLine() {
        var stringReader = new StringReader("GET / HTTP/1.1");
        var input = new BufferedReader(stringReader);

        var request = new RequestReader(input).read();

        assertEquals("GET / HTTP/1.1\r\n", request);
    }

    @Test
    void returnsInputWithRequestLineAndHeaders() {
        var stringReader = new StringReader("GET / HTTP/1.1\r\nHost: localhost\r\n\r\n");
        var input = new BufferedReader(stringReader);

        var request = new RequestReader(input).read();

        assertEquals("GET / HTTP/1.1\r\nHost: localhost\r\n", request);
    }

    @Test
    void returnsInputWithRequestLineHeadersAndBody() {
        var stringReader = new StringReader
                ("POST / HTTP/1.1\r\nHost: localhost\r\n\r\nHello");
        var input = new BufferedReader(stringReader);

        var request = new RequestReader(input).read();

        assertEquals("POST / HTTP/1.1\r\nHost: localhost\r\n\r\nHello", request);
    }
}
