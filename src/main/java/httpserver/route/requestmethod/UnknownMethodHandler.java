package httpserver.route.requestmethod;

import httpserver.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.Response;
import httpserver.http.response.ResponseFactory;

public class UnknownMethodHandler extends MethodHandler {

    @Override
    public Response getResponse(Request request) {
       return ResponseFactory.build(StatusCode.METHOD_NOT_ALLOWED, null, null, null);
    }
}
