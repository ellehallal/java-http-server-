package httpserver.http.response;

import httpserver.http.Protocol;
import httpserver.http.StatusCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {

    @Test
    void returnsStringWithProtocolVersionStatusAndHeaders() {
        var response = new Response()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(StatusCode.OK)
                .setHeaders("Date", "a date");

        assertEquals("HTTP/1.1 200 OK\r\n"
                + "Date: a date\r\n\r\n", response.toString());
    }

    @Test
    void returnsStringWithProtocolVersionAndStatusOnlyWhenHeaderIsNull() {
        var response = new Response()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(StatusCode.OK)
                .setHeaders(null, null);

        assertEquals("HTTP/1.1 200 OK\r\n\r\n", response.toString());
    }

    @Test
    void returnsStringContainingRequestBody() {
        var response = new Response()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(StatusCode.OK)
                .setHeaders("Date", "a date")
                .setBody("hello");

        assertEquals("HTTP/1.1 200 OK\r\n"
                + "Date: a date\r\n\r\n"
                + "hello", response.toString());
    }
}
