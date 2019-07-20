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
        System.out.println(requestBody);

        assertEquals("", requestBody);
    }

}
