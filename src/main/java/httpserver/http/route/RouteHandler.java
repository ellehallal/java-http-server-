package httpserver.http.route;

import httpserver.http.request.Request;
import httpserver.http.route.requestmethod.MethodHandlerFactory;

public class RouteHandler {

    public static String getResponse(Request request) {
        var clientRequestMethod = request.getRequestMethod();
        var methodHandler = MethodHandlerFactory.getHandler(clientRequestMethod);

        return methodHandler.getResponse(request);
    }
}
