package httpserver.http.request;

import httpserver.http.response.Response;
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
}
