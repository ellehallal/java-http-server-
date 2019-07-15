package httpserver.http.request;

import java.io.BufferedReader;
import java.io.IOException;

public class RequestReader {
    private final BufferedReader input;

    public RequestReader(BufferedReader input) {
        this.input = input;
    }

    public String read() {
        try {
            return input.readLine();
        } catch (IOException e) {
            throw new ReadRequestException(e);
        }
    }
}
