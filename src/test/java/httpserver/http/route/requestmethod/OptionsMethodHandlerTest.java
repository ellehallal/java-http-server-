package httpserver.http.route.requestmethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsMethodHandlerTest {
    @Test
    void returnsThreeAllowedHeadersWhenRequestPathIsMethodOptions() {
        var optionsMethodHandler = new OptionsMethodHandler();
        var response = optionsMethodHandler.getResponse("/method_options");

        assertEquals("HTTP/1.1 200 OK\nAllow: GET, HEAD, OPTIONS", response);
    }

    @Test
    void returnsFiveAllowedHeadersWhenRequestPathIsMethodOptions() {
        var optionsMethodHandler = new OptionsMethodHandler();
        var response = optionsMethodHandler.getResponse("/method_options2");

        assertEquals("HTTP/1.1 200 OK\nAllow: GET, HEAD, OPTIONS, PUT, POST", response);
    }

    @Test
    void returnsStatusCode404ForOtherPaths() {
        var optionsMethodHandler = new OptionsMethodHandler();
        var response = optionsMethodHandler.getResponse("/method_options3");

        assertEquals("HTTP/1.1 404 NOT FOUND", response);
    }
}