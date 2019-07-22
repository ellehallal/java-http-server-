package httpserver;

import httpserver.server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

public class App {
    private static final int PORT = Integer.parseInt(System.getenv("PORT"));

    public static void main(String[] args) {
        try {
            var serverSocket = createServerSocket();
            startServer(serverSocket);
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    private static ServerSocket createServerSocket() {
        try {
            return new ServerSocket(PORT);
        } catch (IOException e) {
            throw new ServerSocketException(e);
        }
    }

    private static void startServer(ServerSocket serverSocket) {
        var executor = Executors.newCachedThreadPool();
        new Server(serverSocket, executor).start();
    }
}
