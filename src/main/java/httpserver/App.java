package httpserver;

import httpserver.route.RouteHandler;
import httpserver.server.ConsoleWriter;
import httpserver.server.Server;

public class App {
    private static final int defaultPort = 5000;

    public static void main(String[] args) {
        var routes = RouteConfig.create();
        var routeHandler = new RouteHandler(routes);
        var port = getPort(args);
        var server = new Server(port, routeHandler);

        server.start();
    }

    private static int getPort(String[] args) {
        if (args.length == 0 || args[0].isEmpty()) {
            ConsoleWriter.println("Using default port: " + defaultPort);
            return defaultPort;
        }

        ConsoleWriter.println("Using port: " + args[0]);
        return Integer.parseInt(args[0]);
    }
}

