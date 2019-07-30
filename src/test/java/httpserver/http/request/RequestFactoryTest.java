package httpserver.http.request;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RequestFactoryTest {

    @Test
    void createsANewInstanceOfResponseWithRequestMethodAndRequestPathSet() {
        var rawRequest = "GET /hello HTTP/1.1";
        var request = RequestFactory.build(rawRequest);

        assertThat(request).isInstanceOf(Request.class);
        assertEquals("GET", request.getRequestMethod());
        assertEquals("/hello", request.getRequestPath());
    }

    @Test
    void createsANewInstanceOfResponseWithRequestMethodRequestPathAndHeadersSet() {
        var rawRequest = "GET /hello HTTP/1.1\r\nHost: localhost:5000\r\n\r\n";
        var request = RequestFactory.build(rawRequest);

        assertThat(request).isInstanceOf(Request.class);
        assertEquals("GET", request.getRequestMethod());
        assertEquals("/hello", request.getRequestPath());
        assertEquals("localhost:5000", request.getRequestHeaders().get("Host"));
    }
}
