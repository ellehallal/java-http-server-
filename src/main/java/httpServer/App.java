package httpServer;

import java.net.ServerSocket;

public class App {
    public static void main(String[] args) {
        try {
            var serverSocket = new ServerSocket(5000);
            var executor = new CurrentThreadExecutor();
            new Server(serverSocket, executor).start();

        } catch (Exception e) {
           handleException(e);
        }
    }

    static void handleException(Exception e) {
        if (e instanceof ClientInputOutputException) {
            ConsoleWriter.println
                    (Messages.clientInputOutputExceptionMessage() + e.getMessage());
        }
        else if (e instanceof ClientSocketException) {
            ConsoleWriter.println
                    (Messages.clientSocketExceptionMessage() + e.getMessage());
        }
        else if (e instanceof ReadResponseException) {
            ConsoleWriter.println
                    (Messages.readResponseExceptionMessage() + e.getMessage());
        }
    }
}
