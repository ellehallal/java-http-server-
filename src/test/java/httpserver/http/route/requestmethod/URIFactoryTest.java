package httpserver.http.route.requestmethod;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class URIFactoryTest {
    @Test
    void createsANewURIInstance() {
        var uri = URIFactory.build
                ("http://", "localhost", 8000, "/bonjour");

        assertThat(uri).isInstanceOf(URI.class);
    }

    @Test
    void createsANewURIInstanceWithDefaultProtocol() {
        var uri = URIFactory.build
                ("localhost", 8000, "/bonjour");

        assertThat(uri).isInstanceOf(URI.class);
    }

    @Test
    void createsANewURIInstanceWithDefaultProtocolAndHostAddress() {
        var uri = URIFactory.build(8000, "/bonjour");

        assertThat(uri).isInstanceOf(URI.class);
    }
}