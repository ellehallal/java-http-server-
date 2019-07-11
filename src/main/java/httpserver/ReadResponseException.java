package httpserver;

public class ReadResponseException extends RuntimeException {

    ReadResponseException(Exception cause) {
        super(cause);
    }
}
