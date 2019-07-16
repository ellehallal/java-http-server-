package httpserver.http.response;

import httpserver.http.Protocol;
import httpserver.http.StatusCode;

public class Response {
    private Protocol protocol;
    private StatusCode statusCode;
    private String headers;

    public Response setProtocol(Protocol protocol) {
        this.protocol = protocol;
        return this;
    }

    public Response setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public Response setHeaders(String headers) {
        this.headers = headers;
        return this;
    }

    public String toString() {
        return protocol.getVersion()
                + getStatusCode()
                + getHeaders();
    }

    private String getHeaders() {
        return headers != null ? "\n" + headers : "";
    }

    private String getStatusCode() {
        return " " + statusCode.getMessage();
    }
}
