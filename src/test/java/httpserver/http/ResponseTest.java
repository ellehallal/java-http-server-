package httpserver.http;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {

    @Test
    void getResponseWithProtocolVersionStatusAndHeaders() {
        var response = new Response();
        var builtResponse = response.buildResponse(ProtocolVersion.HTTP_1_1, StatusCode.OK, "Date: a date");

        assertEquals("HTTP/1.1 200 OK\nDate: a date", builtResponse);
    }

    @Test
    void getResponseWithProtocolVersionAndStatusOnly() {
        var response = new Response();
        var builtResponse = response.buildResponse(ProtocolVersion.HTTP_1_1, StatusCode.OK);

        assertEquals("HTTP/1.1 200 OK", builtResponse);
    }
}
