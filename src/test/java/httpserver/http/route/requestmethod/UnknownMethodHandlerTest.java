package httpserver.http.route.requestmethod;

import httpserver.http.request.RequestFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnknownMethodHandlerTest {

    @Test
    void returnsStatusCode405WhenRequestMethodDoesNotExist() {
        var separator = "\r\n";
        var rawRequest = "DELETE /get_with_body HTTP/1.1";
        var request = RequestFactory.build(rawRequest);
        var unknownMethodHandler = new UnknownMethodHandler();
        var response = unknownMethodHandler.getResponse(request);
        assertEquals("HTTP/1.1 405 METHOD NOT ALLOWED" + separator, response);
    }
}
