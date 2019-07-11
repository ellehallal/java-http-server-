package httpServer;

public class RouteHandler {
    private final String request;

    public RouteHandler(String request) {
        this.request = request;
    }

    String getResponse() {
        var requestMethod = new RequestSplitter(request).getRequestMethod();
        var requestPath = new RequestSplitter(request).getRequestPath();

        if (requestMethod.equals("GET")
                && requestPath.equals("/simple_get")) {
            return simpleGetResponse();
        }
        return notFound();
    }

    private String simpleGetResponse() {
        return "HTTP/1.1 200 OK";
    }

    private String notFound() {
        return "HTTP/1.1 404 NOT FOUND";
    }


}
