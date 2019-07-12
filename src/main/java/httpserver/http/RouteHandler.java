package httpserver.http;

public class RouteHandler {
    private final String request;

    public RouteHandler(String request) {
        this.request = request;
    }

    String getResponse() {
        var requestMethod = new RequestSplitter(request).getRequestMethod();
        var requestPath = new RequestSplitter(request).getRequestPath();

        if (requestMethod.equals(RequestMethod.GET.toString())
                && requestPath.equals("/simple_get")) {
            return simpleGetResponse();
        } else if (requestMethod.equals(RequestMethod.OPTIONS.toString())
                && requestPath.equals("/method_options")) {
            return methodOptionsResponse();
        }
        return notFound();
    }

    private String simpleGetResponse() {
        var response = new Response();
        response.setProtocolVersion(ProtocolVersion.HTTP_1_1.getVersion());
        response.setStatusCode(StatusCode.OK.getMessage());
        return response.getResponse();
    }

    private String methodOptionsResponse() {
        var response = new Response();
        response.setProtocolVersion(ProtocolVersion.HTTP_1_1.getVersion());
        response.setStatusCode(StatusCode.OK.getMessage());
        response.setHeaders("Allow: GET, HEAD, OPTIONS");
        return response.getResponse();
    }

    private String notFound() {
        var response = new Response();
        response.setProtocolVersion(ProtocolVersion.HTTP_1_1.getVersion());
        response.setStatusCode(StatusCode.NOT_FOUND.getMessage());
        return response.getResponse();
    }
}
