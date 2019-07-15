package httpserver.http.response;

import httpserver.http.Protocol;
import httpserver.http.StatusCode;

public class ResponseBuilder {
    private Protocol protocol;
    private StatusCode statusCode;
    private String headers;

    public ResponseBuilder setProtocol(Protocol protocol) {
        this.protocol = protocol;
        return this;
    }

    public ResponseBuilder setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public ResponseBuilder setHeaders(String headers) {
        this.headers = headers;
        return this;
    }

    public String build() {
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
