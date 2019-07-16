package httpserver.http.route;

import httpserver.http.request.Request;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RouteHandlerTest {
    @Test
    void returns200StatusWithNoHeadersAndEmptyBodyWhenRequestPathIsSimpleGet() {
        var request = new Request()
                .setRequestMethod("GET")
                .setRequestPath("/simple_get");
        var routeHandler = new RouteHandler(request);
        var response = routeHandler.getResponse();

        assertEquals("HTTP/1.1 200 OK", response);
    }

    @Test
    void returns404StatusWhenPathDoesNotExist() {
        var request = new Request()
                .setRequestMethod("GET")
                .setRequestPath("/some_path");
        var routeHandler = new RouteHandler(request);
        var response = routeHandler.getResponse();

        assertEquals("HTTP/1.1 404 NOT FOUND", response);
    }

    @Test
    void returns200StatusWithHeadersAndEmptyBodyWhenRequestMethodIsOptionsAndPathIsMethodOptions() {
        var request = new Request()
                .setRequestMethod("OPTIONS")
                .setRequestPath("/method_options");
        var routeHandler = new RouteHandler(request);
        var response = routeHandler.getResponse();

        assertEquals("HTTP/1.1 200 OK\nAllow: GET, HEAD, OPTIONS", response);
    }

    @Test
    void returns200StatusWithHeadersAndEmptyBodyWhenRequestMethodIsOptionsAndPathIsMethodOptions2() {
        var request = new Request()
                .setRequestMethod("OPTIONS")
                .setRequestPath("/method_options2");
        var routeHandler = new RouteHandler(request);
        var response = routeHandler.getResponse();

        assertEquals("HTTP/1.1 200 OK\nAllow: GET, HEAD, OPTIONS, PUT, POST", response);
    }
}
