package httpserver.http.response;

import httpserver.http.Protocol;
import httpserver.http.StatusCode;

public class Response {
    private Protocol protocol;
    private StatusCode statusCode;
    private String headers;
    private final String separator = "\r\n";

    public Response setProtocol(Protocol protocol) {
        this.protocol = protocol;
        return this;
    }

    public Response setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public Response setHeaders(String name, String value) {
        if (name == null || value == null) {
            this.headers = null;
        } else {
            this.headers = name
                    + ": "
                    + value;
        }
        return this;
    }

    public String toString() {
        return protocol.getVersion()
                + getStatusCode()
                + getHeaders();
    }

    private String getStatusCode() {
        return " " + statusCode.getMessage() + separator;
    }

    private String getHeaders() {
        return headers != null ? headers + separator  + separator : "";
    }
}
