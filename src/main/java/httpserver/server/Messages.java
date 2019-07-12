package httpserver.server;

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

    public static String clientInputOutputExceptionMessage() {
        return "Client input/output exception ";
    }

    public static String clientSocketExceptionMessage() {
        return "Client socket exception ";
    }

    public static String clientCloseConnectionExceptionMessage() {
        return "Client close connection exception ";
    }

    public static String readRequestExceptionMessage() {
        return "Read response exception ";
    }
}
