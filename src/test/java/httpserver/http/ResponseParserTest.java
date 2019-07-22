package httpserver.http;

import httpserver.http.response.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResponseParserTest {

    @Test
    void returnsTheResponseAsAString() {
        var response = new Response()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(StatusCode.OK)
                .setHeaders("Allow", "GET, POST, HEAD, OPTIONS");
        System.out.println(response);

        var responseString = ResponseParser.parse(response);

        assertEquals("HTTP/1.1 200 OK\r\n"
                + "Allow: GET, POST, HEAD, OPTIONS\r\n", responseString);
    }
}
