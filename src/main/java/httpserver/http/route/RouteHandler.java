package httpserver.http.route;


import httpserver.http.RequestMethod;
import httpserver.http.StatusCode;
import httpserver.http.request.RequestParser;
import httpserver.http.response.ResponseFactory;
import httpserver.http.route.requestmethod.GetMethodHandler;
import httpserver.http.route.requestmethod.OptionsMethodHandler;

public class RouteHandler {
    private final String request;

    public RouteHandler(String request) {
        this.request = request;
    }

    public String getResponse() {
        var requestSplitter = new RequestParser(request);
        var requestMethod = requestSplitter.getRequestMethod();
        var requestPath = requestSplitter.getRequestPath();
        return selectResponse(requestMethod, requestPath);
    }

    private String selectResponse(String requestMethod, String requestPath) {
        if (requestMethod.equals(RequestMethod.GET.toString())) {
            return new GetMethodHandler().getResponse(requestPath);
        } else if (requestMethod.equals(RequestMethod.OPTIONS.toString())) {
            return new OptionsMethodHandler().getResponse(requestPath);
        }
        return ResponseFactory.build(StatusCode.NOT_FOUND, null).toString();
    }
}
