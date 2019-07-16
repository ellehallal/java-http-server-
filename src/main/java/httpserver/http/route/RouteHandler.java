package httpserver.http.route;

import httpserver.http.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.ResponseFactory;
import httpserver.http.route.requestmethod.MethodHandlerFactory;

public class RouteHandler {

    public static String getResponse(Request request) {
        var clientRequestMethod = request.getRequestMethod();
        var methodHandler = MethodHandlerFactory.getHandler(clientRequestMethod);

        if (methodHandler == null) {
            return ResponseFactory.build(StatusCode.NOT_FOUND, null, null).toString();
        }
        return methodHandler.getResponse(request);
    }
}
