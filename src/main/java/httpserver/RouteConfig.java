package httpserver;

import httpserver.route.Route;
import httpserver.route.RouteBuilder;
import httpserver.route.Routes;
import httpserver.route.URIFactory;

public class RouteConfig {

    public static Routes create() {
        return new Routes()
                .addRoute(routeWithDefaultHandler(
                        RequestMethod.GET, "/simple_get"))
                .addRoute(routeWithDefaultHandler(
                        RequestMethod.HEAD, "/simple_get"))
                .addRoute(routeWithDefaultHandler(
                        RequestMethod.GET, "/method_options"))
                .addRoute(routeWithDefaultHandler(
                        RequestMethod.HEAD, "/method_options"))
                .addRoute(routeWithDefaultHandler(
                        RequestMethod.OPTIONS, "/method_options"))
                .addRoute(routeWithDefaultHandler(
                        RequestMethod.GET, "/method_options2"))
                .addRoute(routeWithDefaultHandler(
                        RequestMethod.HEAD, "/method_options2"))
                .addRoute(routeWithDefaultHandler(
                        RequestMethod.OPTIONS, "/method_options2"))
                .addRoute(routeWithDefaultHandler(
                        RequestMethod.PUT, "/method_options2"))
                .addRoute(routeWithDefaultHandler(
                        RequestMethod.POST, "/method_options2"))
                .addRoute(routeWithDefaultHandler(
                        RequestMethod.HEAD, "/get_with_body"))
                .addRoute(routeWithDefaultHandler(
                        RequestMethod.OPTIONS, "/get_with_body"))
                .addRoute(redirectRoute())
                .addRoute(postRoute());
    }

    private static Route redirectRoute() {
        return RouteBuilder.build(RequestMethod.GET, "/redirect", (request, response) -> {
            response.setStatusCode(StatusCode.MOVED_PERMANENTLY)
                    .setHeaders("Location", URIFactory.build(request, "/simple_get").toString());
            return response;
        });
    }

    private static Route postRoute() {
        return RouteBuilder.build(RequestMethod.POST, "/echo_body", (request, response) -> {
            response.setBody(request.getRequestBody());
            return response;
        });
    }

    private static Route routeWithDefaultHandler(RequestMethod requestMethod, String path) {
        return RouteBuilder.build(requestMethod, path, (request, response) -> {
            response.setStatusCode(StatusCode.OK);
            return response;
        });
    }
}
