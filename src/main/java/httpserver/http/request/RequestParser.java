package httpserver.http.request;

import java.util.Arrays;
import java.util.HashMap;

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

    public HashMap getRequestHeaders() {
        var requestHeaders = new HashMap<String, String>();
        var splitRequest = splitRequest();
        var endOfHeadersIndex = splitRequest.length;

        if(!isRequestBodyEmpty()) endOfHeadersIndex -=1;

            if(endOfHeadersIndex < 1) {
                return requestHeaders;
            }

        var rawRequestHeaders = Arrays.copyOfRange(splitRequest, 1, endOfHeadersIndex);

        for (String header : rawRequestHeaders) {
            if(!header.isEmpty()) {
                var splitHeader = header.split(": ");
                requestHeaders.put(splitHeader[0], splitHeader[1]);
            }
        }
        return requestHeaders;
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

    private String[] splitRequest() {
        return clientRequestString.split(SEPARATOR);
    }

    private boolean isRequestBodyEmpty() {
        return clientRequestString.endsWith(SEPARATOR);
    }
}
