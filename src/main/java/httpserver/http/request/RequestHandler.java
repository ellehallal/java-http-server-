package httpserver.http.request;

import java.io.BufferedReader;
import java.io.IOException;

public class RequestHandler {
    private final BufferedReader input;

    public RequestHandler(BufferedReader input) {
        this.input = input;
    }

    public String readResponse() {
        try {
            return input.readLine();
        } catch (IOException e) {
            throw new ReadResponseException(e);
        }
    }
}
