package httpserver.http;

import httpserver.route.RouteHandler2;
import httpserver.route.Routes;
import httpserver.server.RequestResponseHandler;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RequestResponseHandlerTest {

    @Test
    void returnsAResponseAsAString() {
        var request = "GET /unconfigured HTTP/1.1";
        System.setIn(new ByteArrayInputStream(request.getBytes()));
        var inputStreamReader = new InputStreamReader(System.in);
        var input = new BufferedReader(inputStreamReader);
        var outputStream = new ByteArrayOutputStream();
        var output = new PrintWriter(outputStream, true);
        var routes = new Routes();
        var routeHandler = new RouteHandler2(routes);

        var requestResponseHandler = new RequestResponseHandler(input, output, routeHandler);
        requestResponseHandler.run();

        assertEquals("HTTP/1.1 404 NOT FOUND\r\n\r\n", outputStream.toString());
    }
}
