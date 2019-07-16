package httpserver.http.route.requestmethod;

import httpserver.http.request.RequestFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsMethodHandlerTest {
    @Test
    void returnsThreeAllowedHeadersWhenRequestPathIsMethodOptions() {
        var rawRequest = "OPTIONS /method_options HTTP/1.1";
        var request = RequestFactory.build(rawRequest);
        var optionsMethodHandler = new OptionsMethodHandler();
        var response = optionsMethodHandler.getResponse(request);

        assertEquals("HTTP/1.1 200 OK\nAllow: GET, HEAD, OPTIONS", response);
    }

    @Test
    void returnsFiveAllowedHeadersWhenRequestPathIsMethodOptions() {
        var rawRequest = "OPTIONS /method_options2 HTTP/1.1";
        var request = RequestFactory.build(rawRequest);
        var optionsMethodHandler = new OptionsMethodHandler();
        var response = optionsMethodHandler.getResponse(request);

        assertEquals("HTTP/1.1 200 OK\nAllow: GET, HEAD, OPTIONS, PUT, POST", response);
    }

    @Test
    void returnsStatusCode404ForOtherPaths() {
        var rawRequest = "OPTIONS /method_options3 HTTP/1.1";
        var request = RequestFactory.build(rawRequest);
        var optionsMethodHandler = new OptionsMethodHandler();
        var response = optionsMethodHandler.getResponse(request);

        assertEquals("HTTP/1.1 404 NOT FOUND", response);
    }
}
