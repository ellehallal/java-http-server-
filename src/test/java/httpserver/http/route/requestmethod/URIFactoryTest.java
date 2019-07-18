package httpserver.http.route.requestmethod;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class URIFactoryTest {
    @Test
    void createsANewURIInstance() {
        var uri = URIFactory.build
                ("http://", "localhost", 8000, "/bonjour");

        assertThat(uri).isInstanceOf(URI.class);
    }
}