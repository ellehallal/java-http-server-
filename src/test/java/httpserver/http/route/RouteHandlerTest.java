package httpserver.http.route;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RouteHandlerTest {
    @Test
    void returns200StatusWithNoHeadersAndEmptyBodyWhenRequestPathIsSimpleGet() {
        var request = "GET /simple_get HTTP/1.1";
        var routeHandler = new RouteHandler(request);
        var response = routeHandler.getResponse();

        assertEquals("HTTP/1.1 200 OK", response);
    }

    @Test
    void returns404StatusWhenPathDoesNotExist() {
        var request = "GET /some_path HTTP/1.1";
        var routeHandler = new RouteHandler(request);
        var response = routeHandler.getResponse();

        assertEquals("HTTP/1.1 404 NOT FOUND", response);
    }

    @Test
    void returns200StatusWithHeadersAndEmptyBodyWhenRequestMethodIsOptionsAndPathIsMethodOptions() {
        var request = "OPTIONS /method_options HTTP/1.1";
        var routeHandler = new RouteHandler(request);
        var response = routeHandler.getResponse();

        assertEquals("HTTP/1.1 200 OK\nAllow: GET, HEAD, OPTIONS", response);
    }

    @Test
    void returns200StatusWithHeadersAndEmptyBodyWhenRequestMethodIsOptionsAndPathIsMethodOptions2() {
        var request = "OPTIONS /method_options2 HTTP/1.1";
        var routeHandler = new RouteHandler(request);
        var response = routeHandler.getResponse();

        assertEquals("HTTP/1.1 200 OK\nAllow: GET, HEAD, OPTIONS, PUT, POST", response);
    }
}
