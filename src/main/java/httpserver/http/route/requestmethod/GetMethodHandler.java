package httpserver.http.route.requestmethod;

import httpserver.http.StatusCode;

public class GetMethodHandler extends MethodHandler {

    public String getResponse(String requestPath) {
        switch (requestPath) {
            case "/simple_get":
                return buildResponse(StatusCode.OK, null);
            default:
                return buildNotFoundResponse();
        }
    }
}
