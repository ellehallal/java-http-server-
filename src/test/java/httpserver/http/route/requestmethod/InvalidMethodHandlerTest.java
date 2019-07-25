package httpserver.http.route.requestmethod;

import httpserver.http.request.RequestFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvalidMethodHandlerTest {

    @Test
    void getResponse() {
        var rawRequest = "INVALID / HTTP/1.1";
        var request = RequestFactory.build(rawRequest);
        var invalidMethodHandler = new InvalidMethodHandler();

        var response = invalidMethodHandler.getResponse(request);

        assertEquals("HTTP/1.1 400 BAD REQUEST" + "\r\n", response.toString());
    }
}
