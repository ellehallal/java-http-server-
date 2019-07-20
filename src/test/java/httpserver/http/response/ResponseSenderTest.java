package httpserver.http.response;

import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

class ResponseSenderTest {

    @Test
    void outputsTheExpectedResponse() {
        var stringWriter = new StringWriter();
        var output = new PrintWriter(stringWriter);
        var responseHandler = new ResponseSender(output);

        responseHandler.send("HTTP/1.1 200 OK");

        assertEquals("HTTP/1.1 200 OK", stringWriter.toString());
    }
}
