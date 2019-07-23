package httpserver.http.route.requestmethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class URITest {
    @Test
    void returnsURIAsAString() {
        var uri = new URI()
                .setProtocol("http")
                .setHostAddress("localhost")
                .setPath("/hello")
                .toString();
        assertEquals(uri, "http://localhost:5000/hello");
    }

    @Test
    void returnsURIWithProtocolWhenProtocolIsNull() {
        var uri = new URI()
                .setHostAddress("localhost")
                .setPort(5000)
                .setPath("/hello")
                .toString();
        assertEquals(uri, "http://localhost:5000/hello");
    }

    @Test
    void returnsURIWithDefaultHostAddressWhenHostAddressIsNull() {
        var uri = new URI()
                .setProtocol("http")
                .setPort(5000)
                .setPath("/hello")
                .toString();
        assertEquals(uri, "http://127.0.0.1:5000/hello");
    }

    @Test
    void returnsURIAsAStringWithoutPath() {
        var uri = new URI()
                .setProtocol("http")
                .setHostAddress("localhost")
                .setPort(5000)
                .toString();
        assertEquals(uri, "http://localhost:5000");
    }

    @Test
    void returnsURIWithPortEnvValueWhenPortIsNotDefined() {
        var uri = new URI()
                .setProtocol("http")
                .setHostAddress("localhost")
                .setPath("/hello")
                .toString();
        assertEquals(uri, "http://localhost:5000/hello");
    }
}
