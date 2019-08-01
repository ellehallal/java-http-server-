package httpserver.server;

import httpserver.route.RouteHandler;
import httpserver.route.RouteHandler2;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executor;

public class ServerRunner {
    private final ServerSocket serverSocket;
    private final Executor executor;
    private boolean isServerRunning = true;
    private final RouteHandler2 routeHandler;

    public ServerRunner(ServerSocket serverSocket, Executor executor, RouteHandler2 routeHandler) {
        this.serverSocket = serverSocket;
        this.executor = executor;
        this.routeHandler = routeHandler;
    }

    public void start() {
        ConsoleWriter.println(ServerMessage.SERVER_STARTED.toString());
        while (isServerRunning) listenForClient();
    }

    void listenForClient() {
        try {
            var clientSocket = serverSocket.accept();
            ConsoleWriter.println(ServerMessage.CLIENT_CONNECTED.toString());
            executor.execute(new ClientHandler(clientSocket, routeHandler));
        } catch (IOException e) {
            throw new ClientSocketException(e);
        }
    }
}
