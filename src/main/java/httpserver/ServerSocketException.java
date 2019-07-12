package httpserver;

public class ServerSocketException extends RuntimeException {
    ServerSocketException(Exception cause) {
        super(cause);
    }
}
