package httpServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executor;

public class Server {
    private final ServerSocket serverSocket;
    private final Executor executor;
    private boolean isServerRunning = true;

    public Server(ServerSocket serverSocket, Executor executor) {
        this.serverSocket = serverSocket;
        this.executor = executor;
    }

    void start() {
        ConsoleWriter.println("Server started");
        while (isServerRunning) listenForClient();
    }

    void listenForClient() {
        try {
            var clientSocket = serverSocket.accept();
            ConsoleWriter.println("open socket");
            executor.execute(new ClientHandler(clientSocket));

            ConsoleWriter.println("close socket");
            clientSocket.close();
        } catch (IOException e) {
            throw new ClientSocketException(e);
        }
    }
}
