package httpserver.http;

enum StatusCode {
    OK("200 OK"),
    NOT_FOUND("404 NOT FOUND");

    private final String message;

    StatusCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
