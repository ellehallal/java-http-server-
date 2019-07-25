package httpserver.http.request;

import httpserver.http.Protocol;
import httpserver.http.RequestMethod;

public class RequestParser {
    private String rawRequest;
    private static final String SEPARATOR = "\r\n";

    public RequestParser(String rawRequest) {
        this.rawRequest = rawRequest;
    }

    public String getRequestMethod() {
        var splitRequestLine = validateRequestLine();
        return splitRequestLine[0];
    }

    public String getRequestPath() {
        var splitRequestLine = validateRequestLine();
        return splitRequestLine[1];
    }

    public String getRequestBody() {
        if(isRequestBodyEmpty()) return "";

        var splitRequest = splitRequest();
        return splitRequest[splitRequest.length -1];
    }

    private String[] splitRequest () {
        return rawRequest.split(SEPARATOR);
    }

    private String[] splitRequestLine() {
        var splitRequest = splitRequest();
        var requestLine = splitRequest[0];

        return requestLine.split(" ");
    }

    private boolean isRequestBodyEmpty() {
        return rawRequest.endsWith(SEPARATOR);
    }

    private String[] validateRequestLine() {
        if (isRequestEmpty()) rawRequest = invalidRequest();

        return splitRequestLine();
    }

    private boolean isRequestEmpty() {
        return rawRequest.isEmpty();
    }

    private String invalidRequest() {
        var requestMethod = RequestMethod.INVALID.toString();
        var path = "/";
        var protocol = Protocol.HTTP_1_1.getVersion();
        return requestMethod
                + " "
                + path
                + " "
                + protocol;
    }
}
