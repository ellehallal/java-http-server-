package httpServer;

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

    private String[] splitRequestLine(String request) {
        return request.split(" ");
    }

    String getRequestMethod(String request) {
        var splitRequest = splitRequestLine(request);
        return splitRequest[0];
    }

    String getRequestPath(String request) {
        var splitRequest = splitRequestLine(request);
        return splitRequest[1];
    }
}
