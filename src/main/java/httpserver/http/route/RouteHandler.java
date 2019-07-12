package httpserver.http.route;

import httpserver.http.*;
import httpserver.http.request.RequestSplitter;
import httpserver.http.response.Response;

public class RouteHandler {
    private final String request;

    public RouteHandler(String request) {
        this.request = request;
    }

    public String getResponse() {
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
        return response.buildResponse(ProtocolVersion.HTTP_1_1, StatusCode.OK);
    }

    private String methodOptionsResponse() {
        var response = new Response();
        var header = "Allow: GET, HEAD, OPTIONS";
        return response.buildResponse(ProtocolVersion.HTTP_1_1, StatusCode.OK, header);
    }

    private String notFound() {
        var response = new Response();
        return response.buildResponse(ProtocolVersion.HTTP_1_1, StatusCode.NOT_FOUND);
    }
}
