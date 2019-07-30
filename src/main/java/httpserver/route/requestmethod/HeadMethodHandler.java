package httpserver.route.requestmethod;

import httpserver.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.Response;
import httpserver.http.response.ResponseFactory;

public class HeadMethodHandler extends MethodHandler {

    @Override
    public Response getResponse(Request request) {
        var requestPath = request.getRequestPath();

        switch (requestPath) {
            case "/simple_get":
            case "/get_with_body":
                return ResponseFactory.build(StatusCode.OK, null, null, null);
            default:
                return ResponseFactory.build(StatusCode.NOT_FOUND, null, null, null);
        }
    }
}
