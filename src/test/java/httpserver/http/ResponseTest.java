package httpserver.http;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {

    @Test
    void getResponseWithProtocolVersionStatusAndHeaders() {
        var response = new Response();
        response.setProtocolVersion("HTTP/1.1");
        response.setStatusCode("200 OK");
        response.setHeaders("Date: a date");

        assertEquals("HTTP/1.1 200 OK\nDate: a date", response.getResponse());
    }

    @Test
    void getResponseWithProtocolVersionAndStatusOnly() {
        var response = new Response();
        response.setProtocolVersion("HTTP/1.1");
        response.setStatusCode("200 OK");

        assertEquals("HTTP/1.1 200 OK", response.getResponse());
    }
}