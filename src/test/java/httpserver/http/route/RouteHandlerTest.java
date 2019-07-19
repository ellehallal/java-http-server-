package httpserver.http.route;

import httpserver.http.request.Request;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RouteHandlerTest {

    String separator = "\r\n";

    @Test
    void returns200StatusWithNoHeadersAndEmptyBodyWhenRequestPathIsSimpleGet() {
        var request = new Request()
                .setRequestMethod("GET")
                .setRequestPath("/simple_get");

        var response = RouteHandler.getResponse(request);

        assertEquals("HTTP/1.1 200 OK" + separator, response);
    }

    @Test
    void returns404StatusWhenPathDoesNotExist() {
        var request = new Request()
                .setRequestMethod("GET")
                .setRequestPath("/some_path");

        var response = RouteHandler.getResponse(request);

        assertEquals("HTTP/1.1 404 NOT FOUND" + separator, response);
    }

    @Test
    void returns200StatusWithHeadersAndEmptyBodyWhenRequestMethodIsOptionsAndPathIsMethodOptions() {
        var request = new Request()
                .setRequestMethod("OPTIONS")
                .setRequestPath("/method_options");

        var response = RouteHandler.getResponse(request);

        assertEquals("HTTP/1.1 200 OK"
                + separator
                + "Allow: GET, HEAD, OPTIONS"
                + separator
                + separator, response);
    }

    @Test
    void returns200StatusWithHeadersAndEmptyBodyWhenRequestMethodIsOptionsAndPathIsMethodOptions2() {
        var request = new Request()
                .setRequestMethod("OPTIONS")
                .setRequestPath("/method_options2");

        var response = RouteHandler.getResponse(request);

        assertEquals("HTTP/1.1 200 OK"
                + separator
                + "Allow: GET, HEAD, OPTIONS, PUT, POST"
                + separator
                + separator, response);
    }
}
