package httpserver;

import httpserver.http.ExceptionHandler;
import httpserver.server.CurrentThreadExecutor;
import httpserver.server.Server;

import java.net.ServerSocket;

public class App {
    public static void main(String[] args) {
        try {
            var serverSocket = new ServerSocket(5000);
            var executor = new CurrentThreadExecutor();
            new Server(serverSocket, executor).start();

        } catch (Exception e) {
          new ExceptionHandler(e).handleException();
        }
    }
}
