package httpserver.http.response;

import httpserver.http.ProtocolVersion;
import httpserver.http.StatusCode;

public class Response {
    private ProtocolVersion protocolVersion;
    private StatusCode statusCode;
    private String headers;

    public String buildResponse(ProtocolVersion protocolVersion, StatusCode statusCode) {
        setProtocolVersion(protocolVersion);
        setStatusCode(statusCode);
        return protocolVersion.getVersion() + " " + statusCode.getMessage();
    }

    public String buildResponse(ProtocolVersion protocolVersion, StatusCode statusCode, String headers) {
        setProtocolVersion(protocolVersion);
        setStatusCode(statusCode);
        setHeaders(headers);
        return protocolVersion.getVersion() + " " + statusCode.getMessage() + "\n" + headers;
    }

    private void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    private void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    private void setHeaders(String headers) {
        this.headers = headers;
    }
}
