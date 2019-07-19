package httpserver.http.response;

import httpserver.http.Protocol;
import httpserver.http.StatusCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {

    String separator = "\r\n";

    @Test
    void returnsStringWithProtocolVersionStatusAndHeaders() {
        var response = new Response()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(StatusCode.OK)
                .setHeaders("Date", "a date");

        assertEquals("HTTP/1.1 200 OK"
                + separator
                + "Date: a date"
                + separator, response.toString());
    }

    @Test
    void returnsStringWithProtocolVersionAndStatusOnlyWhenHeaderIsNull() {
        var response = new Response()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(StatusCode.OK)
                .setHeaders(null, null);

        assertEquals("HTTP/1.1 200 OK" + separator, response.toString());
    }
}
