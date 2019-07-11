package httpserver.http;

public class Response {
    private String protocolVersion;
    private String statusCode;
    private String headers;

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getResponse() {
        if (headers == null) {
            return protocolVersion + " " + statusCode;
        } else {
            return protocolVersion + " " + statusCode + "\n" + headers;
        }
    }
}
