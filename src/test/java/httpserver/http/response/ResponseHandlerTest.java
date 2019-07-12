package httpserver.http.response;

import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

class ResponseHandlerTest {

    @Test
    void outputsTheExpectedResponse() {
        var expectedResponse = "HTTP/1.1 200 OK\n";
        var stringWriter = new StringWriter();
        var output = new PrintWriter(stringWriter);
        var responseHandler = new ResponseHandler(output);

        responseHandler.sendResponse("HTTP/1.1 200 OK");

        assertEquals(expectedResponse, stringWriter.toString());
    }
}
