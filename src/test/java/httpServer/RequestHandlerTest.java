package httpServer;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RequestHandlerTest {

    @Test
    void returnsInput() {
        var expectedRequest = "GET / HTTP/1.1";
        var stringReader = new StringReader(expectedRequest);
        var input = new BufferedReader(stringReader);
        var requestHandler = new RequestHandler(input);

        var request = requestHandler.readResponse();

        assertEquals(expectedRequest, request);

    }

    @Test
    void returnsTheRequestMethodGet() {
        var stringReader = new StringReader("GET / HTTP/1.1");
        var input = new BufferedReader(stringReader);
        var requestHandler = new RequestHandler(input);
        var request = requestHandler.readResponse();

        var requestMethod = requestHandler.getRequestMethod(request);

        assertEquals("GET", requestMethod);

    }

    @Test
    void returnsTheRequestPathSimpleGet() {
        var stringReader = new StringReader("GET /simple_get HTTP/1.1");
        var input = new BufferedReader(stringReader);
        var requestHandler = new RequestHandler(input);
        var request = requestHandler.readResponse();

        var requestMethod = requestHandler.getRequestPath(request);

        assertEquals("/simple_get", requestMethod);

    }
}
