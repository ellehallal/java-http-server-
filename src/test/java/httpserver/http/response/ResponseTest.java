package httpserver.http.response;

import httpserver.http.Protocol;
import httpserver.http.StatusCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {

    @Test
    void getResponseWithProtocolVersionStatusAndHeaders() {
        var response = new Response(Protocol.HTTP_1_1, StatusCode.OK, "Date: a date");
        var builtResponse = response.buildResponseWithHeaders();

        assertEquals("HTTP/1.1 200 OK\nDate: a date", builtResponse);
    }

    @Test
    void getResponseWithProtocolVersionAndStatusOnly() {
        var response = new Response(Protocol.HTTP_1_1, StatusCode.OK);
        var builtResponse = response.buildResponse();

        assertEquals("HTTP/1.1 200 OK", builtResponse);
    }
}
