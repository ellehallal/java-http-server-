package httpserver.http.response;

import httpserver.http.Protocol;
import httpserver.http.StatusCode;

public class Response {
    private final Protocol protocol;
    private final StatusCode statusCode;
    private String headers;

    public Response(Protocol protocol, StatusCode statusCode) {
        this.protocol = protocol;
        this.statusCode = statusCode;
    }

    public Response(Protocol protocol, StatusCode statusCode, String headers) {
        this(protocol, statusCode);
        this.headers = headers;
    }

    public String buildResponse() {
        return protocol.getVersion()
                + " "
                + statusCode.getMessage();
    }

    public String buildResponseWithHeaders() {
        return protocol.getVersion()
                + " "
                + statusCode.getMessage()
                + "\n"
                + headers;
    }
}
