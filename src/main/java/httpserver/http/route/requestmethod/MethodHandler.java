package httpserver.http.route.requestmethod;

import httpserver.http.Protocol;
import httpserver.http.StatusCode;
import httpserver.http.response.ResponseBuilder;

public abstract class MethodHandler {

    public abstract String getResponse(String requestPath);

    String buildResponse(StatusCode statusCode, String header) {
        return new ResponseBuilder()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(statusCode)
                .setHeaders(header)
                .build();
    }

    String buildNotFoundResponse() {
        return new ResponseBuilder()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(StatusCode.NOT_FOUND)
                .build();
    }
}
