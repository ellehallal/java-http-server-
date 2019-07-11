package httpServer;

public class RouteHandler {
    private final String request;

    public RouteHandler(String request) {
        this.request = request;
    }

    String getResponse() {
        var requestMethod = new RequestSplitter(request).getRequestMethod();
        var requestPath = new RequestSplitter(request).getRequestPath();

        if (requestMethod.equals("GET") && requestPath.equals("/simple_get")) {
            return simpleGetResponse();
        } else if (requestMethod.equals("OPTIONS") && requestPath.equals("/method_options")) {
            return methodOptionsResponse();
        }
        return notFound();
    }

    private String simpleGetResponse() {
        var response = new Response();
        response.setProtocolVersion("HTTP/1.1");
        response.setStatus("200 OK");
        return response.getResponse();
    }

    private String methodOptionsResponse() {
        var response = new Response();
        response.setProtocolVersion("HTTP/1.1");
        response.setStatus("200 OK");
        response.setHeaders("Allow: GET, HEAD, OPTIONS");
        return response.getResponse();
    }

    private String notFound() {
        var response = new Response();
        response.setProtocolVersion("HTTP/1.1");
        response.setStatus("404 NOT FOUND");
        return response.getResponse();
    }
}
