package httpServer;

public class ClientSocketException extends RuntimeException {
    ClientSocketException(Exception cause) {
        super(cause);
    }
}
