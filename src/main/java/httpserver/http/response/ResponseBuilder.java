package httpserver.http.response;

import httpserver.http.Protocol;
import httpserver.http.StatusCode;

public class ResponseBuilder {

    public static String buildResponse(StatusCode statusCode, String header) {
        return new Response()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(statusCode)
                .setHeaders(header)
                .build();
    }

    public static String buildNotFoundResponse() {
        return new Response()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(StatusCode.NOT_FOUND)
                .build();
    }
}
