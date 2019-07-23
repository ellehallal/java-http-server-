package httpserver.http.request;

public class RequestParser {
    private final String rawRequest;
    private final String separator = "\r\n";

    public RequestParser(String rawRequest) {
        this.rawRequest = rawRequest;
    }

    public String getRequestMethod() {
        var splitRequestLine = splitRequestLine();
        var requestMethod = splitRequestLine[0];
        return requestMethod;
    }

    public String getRequestPath() {
        var splitRequestLine = splitRequestLine();
        var requestPath = splitRequestLine[1];
        return requestPath;
    }

    public String getRequestBody() {
        if(isRequestBodyEmpty()) return "";

        var splitRequest = splitRequest();
        return splitRequest[splitRequest.length -1];
    }

    private String[] splitRequest () {
        return rawRequest.split(separator);
    }

    private String[] splitRequestLine() {
        var splitRequest = splitRequest();
        var requestLine = splitRequest[0];

        return requestLine.split(" ");
    }

    private boolean isRequestBodyEmpty() {
        return rawRequest.endsWith(separator);
    }
}
