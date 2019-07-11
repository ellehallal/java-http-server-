package httpServer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RouteHandlerTest {
    @Test
    void returns200StatusWithNoHeadersAndEmptyBodyWhenRequestPathIsSimpleGet() {
        var expectedOutput = new ArrayList<>(Arrays.asList("HTTP/1.1 200 OK"));
        var request = "GET /simple_get HTTP/1.1";
        var routeHandler = new RouteHandler(request);
        var response = routeHandler.getResponse();

        assertEquals(expectedOutput, response);
    }

    @Test
    void returns404StatusWhenPathDoesNotExist() {
       var expectedOutput = new ArrayList<>(Arrays.asList("HTTP/1.1 404 NOT FOUND"));
        var request = "GET /some_path HTTP/1.1";
        var routeHandler = new RouteHandler(request);
        var response = routeHandler.getResponse();

        assertEquals(expectedOutput, response);
    }

    @Test
    void returns200StatusWithHeadersAndEmptyBodyWhenRequestMethodIsOptionsAndPathIsMethodOptions() {
        var expectedOutput = new ArrayList<>
                (Arrays.asList("HTTP/1.1 200 OK", "Access-Control-Allow-Headers: GET, HEAD, OPTIONS"));
        var request = "OPTIONS /method_options HTTP/1.1";
        var routeHandler = new RouteHandler(request);
        var response = routeHandler.getResponse();

        assertEquals(expectedOutput, response);
    }
}
