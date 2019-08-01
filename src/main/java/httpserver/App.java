package httpserver;

import httpserver.route.Route;
import httpserver.route.RouteBuilder;
import httpserver.route.RouteHandler;
import httpserver.route.Routes;
import httpserver.route.requestmethod.URIFactory;
import httpserver.server.ConsoleWriter;
import httpserver.server.Server;

public class App {
    private static final int defaultPort = 5000;

    public static void main(String[] args) {
        var routes = new Routes();
        routes.addRoute(routeWithDefaultHandler(RequestMethod.GET, "/simple_get"));
        routes.addRoute(routeWithDefaultHandler(RequestMethod.HEAD, "/simple_get"));
        routes.addRoute(routeWithDefaultHandler(RequestMethod.GET, "/method_options"));
        routes.addRoute(routeWithDefaultHandler(RequestMethod.HEAD, "/method_options"));
        routes.addRoute(routeWithDefaultHandler(RequestMethod.OPTIONS, "/method_options"));
        routes.addRoute(routeWithDefaultHandler(RequestMethod.GET, "/method_options_2"));
        routes.addRoute(routeWithDefaultHandler(RequestMethod.HEAD, "/method_options_2"));
        routes.addRoute(routeWithDefaultHandler(RequestMethod.OPTIONS, "/method_options_2"));
        routes.addRoute(routeWithDefaultHandler(RequestMethod.PUT, "/method_options_2"));
        routes.addRoute(routeWithDefaultHandler(RequestMethod.POST, "/method_options_2"));
        routes.addRoute(routeWithDefaultHandler(RequestMethod.HEAD, "/get_with_body"));
        routes.addRoute(routeWithDefaultHandler(RequestMethod.OPTIONS, "/get_with_body"));
        routes.addRoute(redirectRoute());
        routes.addRoute(postRoute());

        var routeHandler = new RouteHandler();
        var port = checkPort(args);
        var server = new Server(port);
        server.start(routeHandler);
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

    private static int checkPort(String[] args) {
        if(args.length == 0 || args[0].isEmpty()) {
            ConsoleWriter.println("Using default port: " + defaultPort);
            return defaultPort;
        }

        ConsoleWriter.println("Using port: " + args[0]);
        return Integer.parseInt(args[0]);
    }
}

