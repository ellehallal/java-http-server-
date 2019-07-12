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
        return protocolVersion.getVersion()
                + " "
                + statusCode.getMessage();
    }

    public String buildResponseWithHeaders() {
        return protocolVersion.getVersion()
                + " "
                + statusCode.getMessage()
                + "\n"
                + headers;
    }
}
