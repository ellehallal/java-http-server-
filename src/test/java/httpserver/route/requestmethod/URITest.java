package httpserver.route.requestmethod;

import httpserver.http.request.RequestFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class URITest {
    @Test
    void returnsURIAsAStringWithProtocolHostPortAndPath() {
        var rawRequest = "GET /simple_get HTTP/1.1\r\nHost: localhost:5000\r\n\r\nThis is the body";
        var request = new RequestFactory().build(rawRequest);

        var uri = new URI(request)
                .setHostAddress()
                .setPort()
                .setPath("/hello")
                .toString();
        assertEquals(uri, "http://localhost:5000/hello");
    }

    @Test
    void returnsURIAsAStringWithProtocolHostPortAndPathWhenThereIsNotARequestBody() {
        var rawRequest = "GET /simple_get HTTP/1.1\r\nHost: localhost:5000\r\n";
        var request = new RequestFactory().build(rawRequest);

        var uri = new URI(request)
                .setHostAddress()
                .setPort()
                .setPath("/hello")
                .toString();
        assertEquals(uri, "http://localhost:5000/hello");
    }
}
