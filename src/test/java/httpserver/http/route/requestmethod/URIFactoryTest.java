package httpserver.http.route.requestmethod;

import httpserver.http.request.RequestFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class URIFactoryTest {

    @Test
    void createsANewURIInstanceWithDefaultProtocolAndHostAddress() {
        var rawRequest = "GET /simple_get HTTP/1.1\r\nHost: localhost:5000\r\n\r\nThis is the body";
        var request = new RequestFactory().build(rawRequest);

        var uri = URIFactory.build(request, "/bonjour");

        assertThat(uri).isInstanceOf(URI.class);
    }
}
