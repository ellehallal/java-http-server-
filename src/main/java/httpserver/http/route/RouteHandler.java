package httpserver.http.route;


import httpserver.http.Protocol;
import httpserver.http.RequestMethod;
import httpserver.http.StatusCode;
import httpserver.http.request.RequestSplitter;
import httpserver.http.response.ResponseBuilder;

public class RouteHandler {
    private final String request;

    public RouteHandler(String request) {
        this.request = request;
    }

    public String getResponse() {
        var requestSplitter = new RequestSplitter(request);
        var requestMethod = requestSplitter.getRequestMethod();
        var requestPath = requestSplitter.getRequestPath();

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
        return new ResponseBuilder()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(StatusCode.OK)
                .build();
    }

    private String methodOptionsResponse() {
        var header = "Allow: GET, HEAD, OPTIONS";
        return new ResponseBuilder()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(StatusCode.OK)
                .setHeaders(header)
                .build();
    }

    private String notFound() {
        return new ResponseBuilder()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(StatusCode.NOT_FOUND)
                .build();
    }
}
