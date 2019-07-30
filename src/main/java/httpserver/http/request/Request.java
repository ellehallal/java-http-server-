package httpserver.http.request;

import java.util.HashMap;

public class Request {
    private String requestMethod;
    private String requestPath;
    private HashMap requestHeaders;
    private String requestBody;

    public String getRequestMethod() {
        return requestMethod;
    }

    public Request setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
        return this;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public Request setRequestPath(String requestPath) {
        this.requestPath = requestPath;
        return this;
    }

    public HashMap getRequestHeaders() {
        return requestHeaders;
    }

    public Request setRequestHeaders(HashMap requestHeaders) {
        this.requestHeaders = requestHeaders;
        return this;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public Request setRequestBody(String requestBody) {
        this.requestBody = requestBody;
        return this;
    }
}
