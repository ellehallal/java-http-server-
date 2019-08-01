package httpserver.server;

import httpserver.route.RouteHandler;
import httpserver.route.RouteHandler2;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

public class Server {

    private final int port;
    private final RouteHandler2 routeHandler;

    public Server(int port, RouteHandler2 routeHandler) {
        this.port = port;
        this.routeHandler = routeHandler;
    }

    public void start() {
        try {
            var serverSocket = createServerSocket();
            startServer(serverSocket, routeHandler);
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    private ServerSocket createServerSocket() {
        try {
            return new ServerSocket(port);
        } catch (IOException e) {
            throw new ServerSocketException(e);
        }
    }

    private void startServer(ServerSocket serverSocket, RouteHandler2 routeHandler) {
        var executor = Executors.newCachedThreadPool();
        new ServerRunner(serverSocket, executor, routeHandler).start();
    }
}
