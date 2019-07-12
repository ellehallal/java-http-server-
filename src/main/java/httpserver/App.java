package httpserver;

import httpserver.server.Server;

import java.net.ServerSocket;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        try {
            var serverSocket = new ServerSocket(5000);
            var executor = Executors.newCachedThreadPool();
            new Server(serverSocket, executor).start();

        } catch (Exception e) {
          ExceptionHandler.handleException(e);
        }
    }
}
