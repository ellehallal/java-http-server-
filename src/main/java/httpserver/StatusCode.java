package httpserver;

public enum StatusCode {
    OK("200 OK"),
    MOVED_PERMANENTLY("301 MOVED PERMANENTLY"),
    BAD_REQUEST("400 BAD REQUEST"),
    NOT_FOUND("404 NOT FOUND"),
    METHOD_NOT_ALLOWED("405 METHOD NOT ALLOWED");

    private final String message;

    StatusCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
