package httpServer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RouteHandlerTest {
    @Test
    void returns200StatusWithNoHeadersAndEmptyBodyWhenRequestPathIsSimpleGet() {
        var routeHandler = new RouteHandler("GET", "/simple_get");
        var response = routeHandler.getResponse();

        assertEquals("HTTP/1.1 200 OK", response);
    }

    @Test
    void returns404StatusWhenPathDoesNotExist() {
        var routeHandler = new RouteHandler("GET", "/some_path");
        var response = routeHandler.getResponse();

        assertEquals("HTTP/1.1 404 NOT FOUND", response);
    }

}
