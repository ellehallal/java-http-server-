package httpserver.http;

public class Response {
    private String protocolVersion;
    private String status;
    private String headers;

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getResponse() {
        if (headers == null) {
            return protocolVersion + " " + status;
        } else {
            return protocolVersion + " " + status + "\n" + headers;
        }
    }
}
