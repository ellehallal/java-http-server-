package httpserver.server;

public class ClientSocketException extends RuntimeException {
    ClientSocketException(Exception cause) {
        super(cause);
    }
}
