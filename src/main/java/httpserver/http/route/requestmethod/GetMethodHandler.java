package httpserver.http.route.requestmethod;

import httpserver.http.Protocol;
import httpserver.http.StatusCode;
import httpserver.http.response.ResponseBuilder;

public class GetMethodHandler {

    public static String getResponse(String requestPath) {
        switch (requestPath) {
            case "/simple_get":
                return buildResponse();
            default:
                return buildNotFoundResponse();
        }
    }

    private static String buildResponse() {
        return new ResponseBuilder()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(StatusCode.OK)
                .build();
    }

    private static String buildNotFoundResponse() {
        return new ResponseBuilder()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(StatusCode.NOT_FOUND)
                .build();
    }
}
