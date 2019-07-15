package httpserver.server;

public enum ServerMessage {

    SERVER_STARTED("Server started"),
    CLIENT_CONNECTED("Client connected"),
    CLIENT_DISCONNECTED("Client disconnected");

    private final String message;

    ServerMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return this.message;
    }
}
