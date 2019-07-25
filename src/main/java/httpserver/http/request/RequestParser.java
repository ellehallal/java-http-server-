package httpserver.http.request;

public class RequestParser {
    private String clientRequestString;
    private static final String SEPARATOR = "\r\n";

    public RequestParser(String clientRequestString) {
        this.clientRequestString = clientRequestString;
    }

    public String getRequestMethod() {
        var splitRequestLine = splitRequestLine();
        return splitRequestLine[0];
    }

    public String getRequestPath() {
        var splitRequestLine = splitRequestLine();
        return splitRequestLine[1];
    }

    public String getRequestBody() {
        if(isRequestBodyEmpty()) return "";

        var splitRequest = splitRequest();
        return splitRequest[splitRequest.length -1];
    }

    private void validateClientRequestString() {
        clientRequestString = RequestStringValidator.validate(clientRequestString);
    }

    private String[] splitRequestLine() {
        validateClientRequestString();
        var splitRequest = splitRequest();
        var requestLine = splitRequest[0];

        return requestLine.split(" ");
    }

    private String[] splitRequest () {
        return clientRequestString.split(SEPARATOR);
    }

    private boolean isRequestBodyEmpty() {
        return clientRequestString.endsWith(SEPARATOR);
    }
}
