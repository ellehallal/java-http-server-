package httpserver.http;

import httpserver.http.request.Request;
import httpserver.http.request.RequestFactory;
import httpserver.http.request.RequestReader;
import httpserver.http.response.Response;
import httpserver.http.response.ResponseSender;
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
        var request = getRequest();
        var response = getResponse(request);
        var responseString = parseResponse(response);
        sendResponse(responseString);
    }

    private Request getRequest() {
        var rawRequest = new RequestReader(input).read();
        return RequestFactory.build(rawRequest);
    }

    private Response getResponse(Request request) {
        return RouteHandler.getResponse(request);
    }

    private String parseResponse(Response response) {
        return ResponseParser.parse(response);
    }

    private void sendResponse(String response) {
        var responseSender = new ResponseSender(output);
        responseSender.send(response);
    }
}
