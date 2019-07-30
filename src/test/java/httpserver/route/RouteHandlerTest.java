package httpserver.route;

import httpserver.http.request.Request;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RouteHandlerTest {

    @Test
    void returns200StatusWithNoHeadersAndEmptyBodyWhenRequestPathIsSimpleGet() {
        var request = new Request()
                .setRequestMethod("GET")
                .setRequestPath("/simple_get");

        var response = RouteHandler.getResponse(request);

        assertEquals("HTTP/1.1 200 OK\r\n\r\n", response.toString());
    }

    @Test
    void returns404StatusWhenPathDoesNotExist() {
        var request = new Request()
                .setRequestMethod("GET")
                .setRequestPath("/some_path");

        var response = RouteHandler.getResponse(request);

        assertEquals("HTTP/1.1 404 NOT FOUND\r\n\r\n", response.toString());
    }

    @Test
    void returns200StatusWithHeadersAndEmptyBodyWhenRequestMethodIsOptionsAndPathIsMethodOptions() {
        var request = new Request()
                .setRequestMethod("OPTIONS")
                .setRequestPath("/method_options");

        var response = RouteHandler.getResponse(request);

        assertEquals("HTTP/1.1 200 OK\r\n"
                + "Allow: GET, HEAD, OPTIONS\r\n\r\n", response.toString());
    }

    @Test
    void returns200StatusWithHeadersAndEmptyBodyWhenRequestMethodIsOptionsAndPathIsMethodOptions2() {
        var request = new Request()
                .setRequestMethod("OPTIONS")
                .setRequestPath("/method_options2");

        var response = RouteHandler.getResponse(request);

        assertEquals("HTTP/1.1 200 OK\r\n"
                + "Allow: GET, HEAD, OPTIONS, PUT, POST\r\n\r\n", response.toString());
    }
}
