package httpserver.http.request;

public class RequestParser {
    private final String rawRequest;

    public RequestParser(String rawRequest) {
        this.rawRequest = rawRequest;
    }

    public String getRequestMethod() {
        var requestLine = splitRequest()[0];
        var splitRequestLine = splitRequestLine(requestLine);
        return splitRequestLine[0];
    }

    public String getRequestPath() {
        var requestLine = splitRequest()[0];
        var splitRequestLine = splitRequestLine(requestLine);
        return splitRequestLine[1];
    }

    public String getRequestBody() {
        var splitRequest = splitRequest();
        return splitRequest[splitRequest.length -1];
    }

    private String[] splitRequest () {
        return rawRequest.split("\n");
    }

    private String[] splitRequestLine(String requestLine) {
        return requestLine.split(" ");
    }
}
