package httpserver.http.route.requestmethod;

import httpserver.http.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.Response;
import httpserver.http.response.ResponseFactory;

public class InvalidMethodHandler extends MethodHandler {

    public Response getResponse(Request request) {
        return ResponseFactory.build(StatusCode.BAD_REQUEST, null, null, null);
    }
}
