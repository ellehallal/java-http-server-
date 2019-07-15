package httpserver.http.route;


import httpserver.http.Protocol;
import httpserver.http.RequestMethod;
import httpserver.http.StatusCode;
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
        return new Response(Protocol.HTTP_1_1, StatusCode.OK)
                .buildResponse();
    }

    private String methodOptionsResponse() {
        var header = "Allow: GET, HEAD, OPTIONS";
        return new Response(Protocol.HTTP_1_1, StatusCode.OK, header)
                .buildResponseWithHeaders();
    }

    private String notFound() {
        return new Response(Protocol.HTTP_1_1, StatusCode.NOT_FOUND)
                .buildResponse();
    }
}
