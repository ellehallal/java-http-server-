package httpserver.http.route;


import httpserver.http.RequestMethod;
import httpserver.http.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.ResponseFactory;
import httpserver.http.route.requestmethod.GetMethodHandler;
import httpserver.http.route.requestmethod.OptionsMethodHandler;

public class RouteHandler {

    public static String getResponse(Request request) {
        var requestMethod = request.getRequestMethod();
        var requestPath = request.getRequestPath();

        if (requestMethod.equals(RequestMethod.GET.toString())) {
            return new GetMethodHandler().getResponse(requestPath);
        } else if (requestMethod.equals(RequestMethod.OPTIONS.toString())) {
            return new OptionsMethodHandler().getResponse(requestPath);
        }
        return ResponseFactory.build(StatusCode.NOT_FOUND, null).toString();
    }
}
