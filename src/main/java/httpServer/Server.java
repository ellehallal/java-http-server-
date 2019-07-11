package httpServer;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private final ServerSocket serverSocket;
    private boolean isServerRunning = true;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    void start() {
        ConsoleWriter.println("Server started");
        while (isServerRunning) listenForClient();
    }

    void listenForClient() {
        try {
            var clientSocket = serverSocket.accept();
            new ClientHandler(clientSocket).run();
            clientSocket.close();
        } catch (IOException e) {
            throw new ClientSocketException(e);
        }
    }
}
