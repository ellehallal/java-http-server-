package httpserver.server;

public class ServerSocketException extends RuntimeException {
    public ServerSocketException(Exception cause) {
        super(cause);
    }
}
