package httpserver.http.response;

import httpserver.http.ProtocolVersion;
import httpserver.http.StatusCode;

public class Response {
    private final ProtocolVersion protocolVersion;
    private final StatusCode statusCode;
    private String headers;

    public Response(ProtocolVersion protocolVersion, StatusCode statusCode) {
        this.protocolVersion = protocolVersion;
        this.statusCode = statusCode;
    }

    public Response(ProtocolVersion protocolVersion, StatusCode statusCode, String headers) {
        this(protocolVersion, statusCode);
        this.headers = headers;
    }

    public String buildResponse() {
        return protocolVersionToString()
                + " "
                + statusCodeToString();
    }

    public String buildResponseWithHeaders() {
        return protocolVersionToString()
                + " "
                + statusCodeToString()
                + "\n"
                + headers;
    }

    private String protocolVersionToString() {
        return protocolVersion.getVersion();
    }

    private String statusCodeToString() {
        return statusCode.getMessage();
    }
}
