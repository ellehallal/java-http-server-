package httpserver.route.requestmethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestMethodValidatorTest {

    @Test
    void returnsTrueWhenMethodIsInRequestMethodEnum() {
        var isMethodValid = RequestMethodValidator.isRequestMethodValid("GET");

        assertTrue(isMethodValid);
    }

    @Test
    void returnsFalseWhenMethodIsNotInRequestMethodEnum() {
        var isMethodValid = RequestMethodValidator.isRequestMethodValid("DELETE");

        assertFalse(isMethodValid);
    }
}
