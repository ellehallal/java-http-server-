package httpserver.http.route.requestmethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsHandlerTest {
    @Test
    void returnsThreeAllowedHeadersWhenRequestPathIsMethodOptions() {
        var response = OptionsHandler.getResponse("/method_options");

        assertEquals("HTTP/1.1 200 OK\nAllow: GET, HEAD, OPTIONS", response);
    }

    @Test
    void returnsFiveAllowedHeadersWhenRequestPathIsMethodOptions() {
        var response = OptionsHandler.getResponse("/method_options2");

        assertEquals("HTTP/1.1 200 OK\nAllow: GET, HEAD, OPTIONS, PUT, POST", response);
    }

    @Test
    void returnsStatusCode404ForOtherPaths() {
        var response = OptionsHandler.getResponse("/method_options3");

        assertEquals("HTTP/1.1 404 NOT FOUND", response);
    }
}