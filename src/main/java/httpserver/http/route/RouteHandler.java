package httpserver.http.route;


import httpserver.http.Protocol;
import httpserver.http.RequestMethod;
import httpserver.http.StatusCode;
import httpserver.http.request.RequestSplitter;
import httpserver.http.response.ResponseBuilder;
import httpserver.http.route.requestmethod.GetMethodHandler;
import httpserver.http.route.requestmethod.OptionsMethodHandler;

public class RouteHandler {
    private final String request;

    public RouteHandler(String request) {
        this.request = request;
    }

    public String getResponse() {
        var requestSplitter = new RequestSplitter(request);
        var requestMethod = requestSplitter.getRequestMethod();
        var requestPath = requestSplitter.getRequestPath();

        return selectResponse(requestMethod, requestPath);
    }

    private String selectResponse(String requestMethod, String requestPath) {
        if (requestMethod.equals(RequestMethod.GET.toString())) {
            return GetMethodHandler.getResponse(requestPath);
        } else if (requestMethod.equals(RequestMethod.OPTIONS.toString())) {
            return OptionsMethodHandler.getResponse(requestPath);
        }
        return notFound();
    }

    private String notFound() {
        return new ResponseBuilder()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(StatusCode.NOT_FOUND)
                .build();
    }
}
