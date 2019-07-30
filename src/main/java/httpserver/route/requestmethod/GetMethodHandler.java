package httpserver.route.requestmethod;

import httpserver.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.Response;
import httpserver.http.response.ResponseFactory;

public class GetMethodHandler extends MethodHandler {

    public Response getResponse(Request request) {
        var requestPath = request.getRequestPath();

        switch (requestPath) {
            case "/simple_get":
                return ResponseFactory.build(StatusCode.OK, null, null, null);
            case "/get_with_body":
                return ResponseFactory.build(StatusCode.METHOD_NOT_ALLOWED, "Allow", "HEAD, OPTIONS", null);
            case "/redirect":
                return ResponseFactory.build
                        (StatusCode.MOVED_PERMANENTLY, "Location",
                                URIFactory.build(request, "/simple_get").toString(), null);
            default:
                return ResponseFactory.build(StatusCode.NOT_FOUND, null, null, null);
        }
    }
}
