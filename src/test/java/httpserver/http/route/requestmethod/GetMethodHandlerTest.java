package httpserver.http.route.requestmethod;

import httpserver.http.request.RequestFactory;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetMethodHandlerTest {
    String separator = "\r\n";

    @Test
    void returnsStatusCode200WhenPathIsSimpleGet() {
        var rawRequest = "GET /simple_get HTTP/1.1";
        var request = RequestFactory.build(rawRequest);
        var getMethodHandler = new GetMethodHandler();
        var response = getMethodHandler.getResponse(request);

        assertEquals("HTTP/1.1 200 OK\r\n\r\n", response.toString());
    }

    @Test
    void returnsStatusCode405WhenPathIsGetWithBodyAndMethod() {
        var rawRequest = "GET /get_with_body HTTP/1.1";
        var request = RequestFactory.build(rawRequest);
        var getMethodHandler = new GetMethodHandler();
        var response = getMethodHandler.getResponse(request);

        assertEquals("HTTP/1.1 405 METHOD NOT ALLOWED\r\n"
                + "Allow: HEAD, OPTIONS\r\n\r\n", response.toString());
    }

    @Test
    void returnsStatusCode301WhenTheRequestPathRedirect() {
        var rawRequest = "GET /redirect";
        var request = RequestFactory.build(rawRequest);
        var getMethodHandler = new GetMethodHandler();
        var hostAddress = InetAddress.getLoopbackAddress().getHostAddress();

        var response = getMethodHandler.getResponse(request);

        assertEquals("HTTP/1.1 301 MOVED PERMANENTLY\r\n"
                + "Location: http://"+ hostAddress +":5000/simple_get\r\n\r\n", response.toString());
    }

    @Test
    void returnsStatusCode404ForOtherPaths() {
        var rawRequest = "GET /simple_get_request HTTP/1.1";
        var request = RequestFactory.build(rawRequest);
        var getMethodHandler = new GetMethodHandler();
        var response = getMethodHandler.getResponse(request);

        assertEquals("HTTP/1.1 404 NOT FOUND\r\n\r\n", response.toString());
    }

}
