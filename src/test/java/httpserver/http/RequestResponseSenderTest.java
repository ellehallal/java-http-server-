package httpserver.http;

import httpserver.route.RouteHandler2;
import httpserver.route.Routes;
import httpserver.server.RequestResponseHandler;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RequestResponseSenderTest {

    @Test
    void acceptsARequestAndOutputsTheExpectedResponse() {
        var clientRequest = "GET /unconfigured HTTP/1.1";
        var stringReader = new StringReader(clientRequest);
        var input = new BufferedReader(stringReader);
        var stringWriter = new StringWriter();
        var output = new PrintWriter(stringWriter);
        var routes = new Routes();
        var routeHandler = new RouteHandler2(routes);
        var requestResponseHandler = new RequestResponseHandler(input, output, routeHandler);

        requestResponseHandler.run();

        assertEquals("HTTP/1.1 404 NOT FOUND\r\n\r\n", stringWriter.toString());
    }
}
