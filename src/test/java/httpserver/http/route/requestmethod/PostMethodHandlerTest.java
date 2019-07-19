package httpserver.http.route.requestmethod;

import httpserver.http.request.RequestFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostMethodHandlerTest {

    private String separator = "\r\n";

    @Test
    void returnsStatusCode200WithHeadersAndRequestBodyWhenPathIsEchoBody() {
        var rawRequest = "POST /echo_body HTTP/1.1";
        var request = RequestFactory.build(rawRequest);
        var postMethodHandler = new PostMethodHandler();
        var response = postMethodHandler.getResponse(request);
        assertEquals("HTTP/1.1 200 OK" + separator + separator + "hello", response);
    }

    @Test
    void returnsStatusCode404ForOtherPaths() {
        var rawRequest = "GET /simple_get_request HTTP/1.1";
        var request = RequestFactory.build(rawRequest);
        var getMethodHandler = new GetMethodHandler();
        var response = getMethodHandler.getResponse(request);
        assertEquals("HTTP/1.1 404 NOT FOUND" + separator, response);
    }
}
