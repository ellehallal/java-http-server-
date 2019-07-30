package httpserver;

import httpserver.route.RouteHandler;
import httpserver.server.ConsoleWriter;
import httpserver.server.Server;

public class App {
    private static final int defaultPort = 5000;

    public static void main(String[] args) {
        var port = checkPort(args);
        var server = new Server(port);
        var routeHandler = new RouteHandler();

        server.start(routeHandler);
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
