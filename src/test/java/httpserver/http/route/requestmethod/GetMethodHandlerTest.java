package httpserver.http.route.requestmethod;

import httpserver.http.request.RequestFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetMethodHandlerTest {
    @Test
    void returnsStatusCode200WhenPathIsSimpleGet() {
        var rawRequest = "GET /simple_get HTTP/1.1";
        var request = RequestFactory.build(rawRequest);
        var getMethodHandler = new GetMethodHandler();
        var response = getMethodHandler.getResponse(request);

        assertEquals("HTTP/1.1 200 OK", response);
    }

    @Test
    void returnsStatusCode405WhenPathIsGetWithBodyAndMethod() {
        var rawRequest = "GET /get_with_body HTTP/1.1";
        var request = RequestFactory.build(rawRequest);
        var getMethodHandler = new GetMethodHandler();
        var response = getMethodHandler.getResponse(request);

        assertEquals("HTTP/1.1 405 METHOD NOT ALLOWED\nAllow: HEAD, OPTIONS", response);
    }

    @Test
    void returnsStatusCode404ForOtherPaths() {
        var rawRequest = "GET /simple_get_request HTTP/1.1";
        var request = RequestFactory.build(rawRequest);
        var getMethodHandler = new GetMethodHandler();
        var response = getMethodHandler.getResponse(request);

        assertEquals("HTTP/1.1 404 NOT FOUND", response);
    }

}
