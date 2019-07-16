package httpserver.http.request;

public class RequestParser {
    private final String rawRequest;

    public RequestParser(String rawRequest) {
        this.rawRequest = rawRequest;
    }

    public String getRequestMethod() {
        var splitRequest = splitRequestLine();
        return splitRequest[0];
    }

    public String getRequestPath() {
        var splitRequest = splitRequestLine();
        return splitRequest[1];
    }

    private String[] splitRequestLine() {
        return rawRequest.split(" ");
    }
}
