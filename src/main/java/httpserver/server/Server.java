package httpserver.server;

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

    public void start() {
        ConsoleWriter.println(ServerMessage.SERVER_STARTED.toString());
        while (isServerRunning) listenForClient();
    }

    void listenForClient() {
        try {
            var clientSocket = serverSocket.accept();
            ConsoleWriter.println(ServerMessage.CLIENT_CONNECTED.toString());
            executor.execute(new ClientHandler(clientSocket));
        } catch (IOException e) {
            throw new ClientSocketException(e);
        }
    }
}
