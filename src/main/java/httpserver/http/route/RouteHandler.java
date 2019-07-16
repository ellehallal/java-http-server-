package httpserver.http.route;


import httpserver.http.RequestMethod;
import httpserver.http.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.ResponseFactory;
import httpserver.http.route.requestmethod.GetMethodHandler;
import httpserver.http.route.requestmethod.HeadMethodHandler;
import httpserver.http.route.requestmethod.OptionsMethodHandler;

public class RouteHandler {

    public static String getResponse(Request request) {
        var newRequestMethod = request.getRequestMethod();
        var requestMethod = RequestMethod.valueOf(newRequestMethod);

        switch (requestMethod) {
            case GET:
                return new GetMethodHandler().getResponse(request);
            case OPTIONS:
                return new OptionsMethodHandler().getResponse(request);
            case HEAD:
                return new HeadMethodHandler().getResponse(request);
            default:
                return ResponseFactory.build(StatusCode.NOT_FOUND, null, null).toString();
        }
    }
}
