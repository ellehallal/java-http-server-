package httpserver.server;

public class ReadRequestException extends RuntimeException {

    ReadRequestException(Exception cause) {
        super(cause);
    }
}
