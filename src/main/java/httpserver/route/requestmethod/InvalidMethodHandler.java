package httpserver.route.requestmethod;

import httpserver.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.Response;
import httpserver.http.response.ResponseBuilder;

public class InvalidMethodHandler extends MethodHandler {

    public Response getResponse(Request request) {
        return ResponseBuilder.build(StatusCode.BAD_REQUEST, null, null, null);
    }
}
