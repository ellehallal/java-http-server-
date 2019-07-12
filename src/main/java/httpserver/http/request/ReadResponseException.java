package httpserver.http.request;

public class ReadResponseException extends RuntimeException {

    ReadResponseException(Exception cause) {
        super(cause);
    }
}
