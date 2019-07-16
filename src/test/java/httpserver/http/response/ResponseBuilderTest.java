package httpserver.http.response;

import httpserver.http.StatusCode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ResponseBuilderTest {

    @Test
    void returnsAResponseObject() {
        var response = ResponseBuilder.build(StatusCode.OK, "A header");

        assertThat(response instanceof Response);
    }
}
