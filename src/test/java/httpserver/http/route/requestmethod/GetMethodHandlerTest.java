package httpserver.http.route.requestmethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetMethodHandlerTest {
    @Test
    void returnsStatusCode200WhenPathIsSimpleGet() {
        var getMethodHandler = new GetMethodHandler();
        var response = getMethodHandler.getResponse("/simple_get");

        assertEquals("HTTP/1.1 200 OK", response);
    }

    @Test
    void returnsStatusCode404ForOtherPaths() {
        var getMethodHandler = new GetMethodHandler();
        var response = getMethodHandler.getResponse("/simple_get_request");

        assertEquals("HTTP/1.1 404 NOT FOUND", response);
    }

}