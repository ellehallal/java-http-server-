package httpserver.server;

import httpserver.route.RouteHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

public class Server {

    private final int port;

    public Server(int port) {
        this.port = port;
    }

    public void start(RouteHandler routeHandler) {
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

    private void startServer(ServerSocket serverSocket, RouteHandler routeHandler) {
        var executor = Executors.newCachedThreadPool();
        new ServerRunner(serverSocket, executor, routeHandler).start();
    }
}
