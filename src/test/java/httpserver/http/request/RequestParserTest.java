package httpserver.http.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RequestParserTest {

    @Test
    void returnsTheRequestMethodGet() {
        var rawRequest = "GET /simple_get HTTP/1.1\r\n";

        var requestMethod = new RequestParser(rawRequest).getRequestMethod();

        assertEquals("GET", requestMethod);

    }

    @Test
    void returnsTheRequestPathSimpleGet() {
        var rawRequest = "GET /simple_get HTTP/1.1\r\n";

        var requestMethod = new RequestParser(rawRequest).getRequestPath();

        assertEquals("/simple_get", requestMethod);

    }

    @Test
    void returnsTheRequestBody() {
        var rawRequest = "POST /echo_body HTTP/1.1\r\n\r\nHello";

        var requestMethod = new RequestParser(rawRequest).getRequestBody();

        assertEquals("Hello", requestMethod);

    }

}
