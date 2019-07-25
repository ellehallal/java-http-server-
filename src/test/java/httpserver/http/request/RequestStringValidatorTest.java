package httpserver.http.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestStringValidatorTest {

    @Test
    void returnsOriginalClientRequestIfItIsNotEmpty() {
        var clientRequestString = "GET / HTTP/1.1";
        var validatedRequestString = RequestStringValidator.validate(clientRequestString);

        assertEquals(clientRequestString, validatedRequestString);
    }

    @Test
    void returnsNewClientRequestIfOriginalRequestIsEmpty() {
        var clientRequestString = "";
        var validatedRequestString = RequestStringValidator.validate(clientRequestString);

        assertEquals("INVALID / HTTP/1.1", validatedRequestString);
    }
}
