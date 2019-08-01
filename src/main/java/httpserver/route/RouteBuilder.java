package httpserver.route;

import httpserver.RequestMethod;

public class RouteBuilder {

    public static Route build(
            RequestMethod requestMethod, String path, MethodHandler methodHandler) {
        return new Route()
                .setRequestMethod(requestMethod)
                .setPath(path)
                .setMethodHandler(methodHandler);
    }
}
