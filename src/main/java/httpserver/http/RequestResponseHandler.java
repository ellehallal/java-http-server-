package httpserver.http;

import httpserver.http.request.RequestReader;
import httpserver.http.response.ResponseHandler;
import httpserver.http.route.RouteHandler;

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
        return RequestReader.read(input);
    }

    private void sendResponse(String response) {
        new ResponseHandler(output).sendResponse(response);
    }
}
