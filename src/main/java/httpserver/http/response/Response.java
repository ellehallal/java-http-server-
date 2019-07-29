package httpserver.http.response;

import httpserver.http.Protocol;
import httpserver.http.StatusCode;

public class Response {
    private Protocol protocol;
    private StatusCode statusCode;
    private String headers;
    private String body;
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

    public Response setBody(String body) {
        this.body = body;
        return this;
    }

    public String toString() {
        return protocol.getVersion()
                + formatStatusCode()
                + formatHeaders()
                + formatBody();
    }

    private String formatStatusCode() {
        return " " + statusCode.getMessage() + separator;
    }

    private String formatHeaders() {
        return headers != null ? headers + separator : "";
    }

    private String formatBody() {
        return body != null ? separator + body : separator;
    }
}
