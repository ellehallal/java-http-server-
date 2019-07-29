package httpserver.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

public class Server {

    private final int port;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        try {
            var serverSocket = createServerSocket();
            startServer(serverSocket);
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

    private void startServer(ServerSocket serverSocket) {
        var executor = Executors.newCachedThreadPool();
        new ServerRunner(serverSocket, executor).start();
    }
}
