package httpserver.http.route.requestmethod;

import httpserver.http.StatusCode;
import httpserver.http.response.ResponseBuilder;

public class GetMethodHandler extends ResponseBuilder {

    public String getResponse(String requestPath) {
        switch (requestPath) {
            case "/simple_get":
                return ResponseBuilder.buildResponse(StatusCode.OK, null);
            default:
                return ResponseBuilder.buildResponse(StatusCode.NOT_FOUND, null);
        }
    }
}
