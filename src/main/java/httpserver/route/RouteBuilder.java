package httpserver.route;

import httpserver.RequestMethod;
import httpserver.route.method.MethodHandler;

public class RouteBuilder {

    public static Route build(
            RequestMethod requestMethod, String path, MethodHandler methodHandler) {
        return new Route()
                .setRequestMethod(requestMethod)
                .setPath(path)
                .setMethodHandler(methodHandler);
    }
}
