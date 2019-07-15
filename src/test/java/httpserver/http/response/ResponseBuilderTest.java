package httpserver.http.response;

import httpserver.http.Protocol;
import httpserver.http.StatusCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseBuilderTest {

    @Test
    void returnsStringWithProtocolVersionStatusAndHeaders() {
        var response = new ResponseBuilder()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(StatusCode.OK)
                .setHeaders("Date: a date")
                .build();

        assertEquals("HTTP/1.1 200 OK\nDate: a date", response);
    }

    @Test
    void returnsStringWithProtocolVersionAndStatus() {
        var response = new ResponseBuilder()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(StatusCode.OK)
                .build();

        assertEquals("HTTP/1.1 200 OK", response);
    }
}
