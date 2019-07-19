package httpserver.http.request;

public class Request {
    private String requestMethod;
    private String requestPath;
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

    public String getRequestBody() {
        return requestBody;
    }

    public Request setRequestBody(String requestBody) {
        this.requestBody = requestBody;
        return this;
    }
}
