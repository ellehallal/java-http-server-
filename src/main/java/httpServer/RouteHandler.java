package httpServer;

import java.util.ArrayList;

public class RouteHandler {
    private final String request;
    private ArrayList<String> response = new ArrayList<>();

    public RouteHandler(String request) {
        this.request = request;
    }

    ArrayList getResponse() {
        var requestMethod = new RequestSplitter(request).getRequestMethod();
        var requestPath = new RequestSplitter(request).getRequestPath();

        if (requestMethod.equals("GET") && requestPath.equals("/simple_get")) {
            return simpleGetResponse();
        } else if (requestMethod.equals("OPTIONS") && requestPath.equals("/method_options")) {
            return methodOptionsResponse();
        }
        return notFound();
    }

    private ArrayList<String> simpleGetResponse() {
        response.add("HTTP/1.1 200 OK");
        return response;
    }

    private ArrayList<String> methodOptionsResponse() {
        response.add("HTTP/1.1 200 OK");
        response.add("Access-Control-Allow-Headers: GET, HEAD, OPTIONS");
        return response;
    }

    private ArrayList<String> notFound() {
        response.add("HTTP/1.1 404 NOT FOUND");
        return response;
    }
}
