package httpserver.http;

public enum StatusCode {
    OK("200 OK"),
    MOVED_PERMANENTLY("301 MOVED PERMANENTLY"),
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
