package httpserver.http;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class RequestResponseHandler {
    private final BufferedReader input;
    private final PrintWriter output;

    public RequestResponseHandler(BufferedReader input, PrintWriter output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        var request = receiveRequest();
        var response = new RouteHandler(request).getResponse();

        sendResponse(response);
    }

    private String receiveRequest() {
        return new RequestHandler(input).readResponse();
    }

    private void sendResponse(String response) {
        new ResponseHandler(output).sendResponse(response);
    }
}
