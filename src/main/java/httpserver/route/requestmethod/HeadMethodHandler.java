package httpserver.route.requestmethod;

import httpserver.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.Response;
import httpserver.http.response.ResponseBuilder;

public class HeadMethodHandler extends MethodHandler {

    @Override
    public Response getResponse(Request request) {
        var requestPath = request.getRequestPath();

        switch (requestPath) {
            case "/simple_get":
            case "/get_with_body":
                return ResponseBuilder.build(StatusCode.OK, null, null, null);
            default:
                return ResponseBuilder.build(StatusCode.NOT_FOUND, null, null, null);
        }
    }
}
