package httpserver.http.request;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RequestParserTest {

    @Test
    void returnsTheRequestMethodGet() {
        var stringReader = new StringReader("GET / HTTP/1.1");
        var input = new BufferedReader(stringReader);
        var request = RequestReader.read(input);

        var requestMethod = new RequestParser(request).getRequestMethod();

        assertEquals("GET", requestMethod);

    }

    @Test
    void returnsTheRequestPathSimpleGet() {
        var stringReader = new StringReader("GET /simple_get HTTP/1.1");
        var input = new BufferedReader(stringReader);
        var request = RequestReader.read(input);

        var requestMethod = new RequestParser(request).getRequestPath();

        assertEquals("/simple_get", requestMethod);

    }

}
