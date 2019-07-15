package httpserver.http.request;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RequestReaderTest {

    @Test
    void returnsInput() {
        var expectedRequest = "GET / HTTP/1.1";
        var stringReader = new StringReader(expectedRequest);
        var input = new BufferedReader(stringReader);
        var requestHandler = new RequestReader(input);

        var request = requestHandler.read();

        assertEquals(expectedRequest, request);

    }
}
