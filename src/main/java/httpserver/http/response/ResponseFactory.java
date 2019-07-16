package httpserver.http.response;

import httpserver.http.Protocol;
import httpserver.http.StatusCode;

public class ResponseFactory {

    public static Response build(StatusCode statusCode, String header) {
        return new Response()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(statusCode)
                .setHeaders(header);
    }
}
