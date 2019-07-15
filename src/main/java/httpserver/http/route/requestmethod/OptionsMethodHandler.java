package httpserver.http.route.requestmethod;

import httpserver.http.Protocol;
import httpserver.http.StatusCode;
import httpserver.http.response.ResponseBuilder;

public class OptionsMethodHandler {
    public static String getResponse(String requestPath) {
        switch (requestPath) {
            case "/method_options":
                return buildResponse("Allow: GET, HEAD, OPTIONS");
            case "/method_options2":
                return buildResponse("Allow: GET, HEAD, OPTIONS, PUT, POST");
            default:
                return buildNotFoundResponse();
        }
    }

    private static String buildResponse(String header) {
        return new ResponseBuilder()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(StatusCode.OK)
                .setHeaders(header)
                .build();
    }

    private static String buildNotFoundResponse() {
        return new ResponseBuilder()
                .setProtocol(Protocol.HTTP_1_1)
                .setStatusCode(StatusCode.NOT_FOUND)
                .build();
    }
}
