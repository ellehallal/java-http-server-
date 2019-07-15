package httpserver.server;

public class ClientInputOutputException extends RuntimeException {
    public ClientInputOutputException(Exception cause) {
        super(cause);
    }
}
