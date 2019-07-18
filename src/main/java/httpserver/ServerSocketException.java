package httpserver;

class ServerSocketException extends RuntimeException {
    ServerSocketException(Exception cause) {
        super(cause);
    }
}
