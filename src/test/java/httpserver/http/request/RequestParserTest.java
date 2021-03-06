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

        var requestPath = new RequestParser(rawRequest).getRequestPath();

        assertEquals("/simple_get", requestPath);

    }

    @Test
    void returnsTheRequestBody() {
        var rawRequest = "POST /echo_body HTTP/1.1\r\n\r\nHello";

        var requestBody = new RequestParser(rawRequest).getRequestBody();

        assertEquals("Hello", requestBody);

    }

    @Test
    void returnsAnEmptyRequestBodyWhenTheRawRequestDoesNotHaveARequestBody() {
        var rawRequest = "POST /echo_body HTTP/1.1\r\n\r\n";

        var requestBody = new RequestParser(rawRequest).getRequestBody();

        assertEquals("", requestBody);
    }

    @Test
    void returnsARequestLineWithTheInvalidRequestMethodIfRawRequestIsEmpty() {
        var rawRequest = "";

        var requestMethod = new RequestParser(rawRequest).getRequestMethod();
        var requestPath = new RequestParser(rawRequest).getRequestPath();

        assertEquals("INVALID", requestMethod);
        assertEquals("/", requestPath);
    }

    @Test
    void returnsTheHeadersWhenTheBodyIsEmpty() {
        var rawRequest = "POST /echo_body HTTP/1.1\r\nHost: localhost:5000\r\n\r\n";

        var requestParser = new RequestParser(rawRequest);
        var requestHeaders = requestParser.getRequestHeaders();
        var requestBody = requestParser.getRequestBody();

        assertEquals(1, requestHeaders.size());
        assertEquals("localhost:5000", requestHeaders.get("Host"));
        assertEquals("", requestBody);
    }

    @Test
    void returnsTheHeadersWhenTheBodyIsNotEmpty() {
        var rawRequest = "POST /echo_body HTTP/1.1\r\nHost: localhost:5000\r\nHere is the body";
        var requestParser = new RequestParser(rawRequest);
        var requestHeaders = requestParser.getRequestHeaders();
        var requestBody = requestParser.getRequestBody();

        assertEquals(1, requestHeaders.size());
        assertEquals("localhost:5000", requestHeaders.get("Host"));
        assertEquals("Here is the body", requestBody);
    }
}
