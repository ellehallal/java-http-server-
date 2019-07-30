package httpserver.http;

import httpserver.route.RouteHandler;
import httpserver.server.RequestResponseHandler;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

class RequestResponseSenderTest {

    @Test
    void acceptsARequestAndOutputsTheExpectedResponse() {
        var clientRequest = "GET /simple_get HTTP/1.1";
        var stringReader = new StringReader(clientRequest);
        var input = new BufferedReader(stringReader);
        var stringWriter = new StringWriter();
        var output = new PrintWriter(stringWriter);
        var routeHandler = new RouteHandler();
        var requestResponseHandler = new RequestResponseHandler(input, output, routeHandler);

        requestResponseHandler.run();

        assertEquals("HTTP/1.1 200 OK\r\n\r\n", stringWriter.toString());
    }
}
