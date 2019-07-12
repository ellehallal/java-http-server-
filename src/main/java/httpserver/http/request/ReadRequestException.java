package httpserver.http.request;

public class ReadRequestException extends RuntimeException {

    ReadRequestException(Exception cause) {
        super(cause);
    }
}
