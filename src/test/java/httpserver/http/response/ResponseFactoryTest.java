package httpserver.http.response;

import httpserver.http.StatusCode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ResponseFactoryTest {

    @Test
    void returnsAResponseObject() {
        var response = ResponseFactory.build(StatusCode.OK, "A header", "with a value");

        assertThat(response instanceof Response);
    }
}
