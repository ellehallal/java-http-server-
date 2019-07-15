package httpserver.http.route.requestmethod;

import httpserver.http.Protocol;
import httpserver.http.StatusCode;
import httpserver.http.response.Response;

public class ResponseBuilder {

    String buildResponse(StatusCode statusCode, String header) {
        return new Response()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(statusCode)
                .setHeaders(header)
                .build();
    }

    String buildNotFoundResponse() {
        return new Response()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(StatusCode.NOT_FOUND)
                .build();
    }
}
