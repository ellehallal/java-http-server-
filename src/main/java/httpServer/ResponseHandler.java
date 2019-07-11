package httpServer;

import java.io.PrintWriter;

public class ResponseHandler {
    private final PrintWriter output;

    public ResponseHandler(PrintWriter output) {
        this.output = output;
    }

    public void sendResponse(String response) {
        output.println(response);
    }
}
