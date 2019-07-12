package httpServer;

public class ClientInputOutputException extends RuntimeException {
    public ClientInputOutputException(Exception cause) {
        super(cause);
    }
}
