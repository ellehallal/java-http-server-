package httpserver.server;

public class ClientCloseConnectionException extends RuntimeException {
    ClientCloseConnectionException(Exception cause) {
        super(cause);
    }
}
