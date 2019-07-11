package httpServer;

public class Messages {
    static String serverStartedMessage() {
        return "Server started";
    }

    static String clientConnectedMessage() {
        return "Client connected";
    }

    static String clientDisconnectedMessage() {
        return "Client disconnected";
    }

    static String clientInputOutputExceptionMessage() {
        return "Client input/output exception ";
    }

    static String clientSocketExceptionMessage() {
        return "Client socket exception ";
    }

    static String readResponseExceptionMessage() {
        return "Read response exception ";
    }
}
