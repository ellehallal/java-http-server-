package httpserver;

import java.io.BufferedReader;
import java.io.IOException;

class RequestHandler {
    private final BufferedReader input;

    public RequestHandler(BufferedReader input) {
        this.input = input;
    }

    String readResponse() {
        try {
            return input.readLine();
        } catch (IOException e) {
            throw new ReadResponseException(e);
        }
    }
}
