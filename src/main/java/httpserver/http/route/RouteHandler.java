package httpserver.http.route;


import httpserver.http.RequestMethod;
import httpserver.http.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.ResponseFactory;
import httpserver.http.route.requestmethod.GetMethodHandler;
import httpserver.http.route.requestmethod.OptionsMethodHandler;

public class RouteHandler {

    public static String getResponse(Request newRequest) {
        var newRequestMethod = newRequest.getRequestMethod();
        var newRequestPath = newRequest.getRequestPath();
        var requestMethod = RequestMethod.valueOf(newRequestMethod);

        switch (requestMethod) {
            case GET:
                return new GetMethodHandler().getResponse(newRequestPath);
            case OPTIONS:
                return new OptionsMethodHandler().getResponse(newRequestPath);
            default:
                return ResponseFactory.build(StatusCode.NOT_FOUND, null).toString();
        }
    }
}
