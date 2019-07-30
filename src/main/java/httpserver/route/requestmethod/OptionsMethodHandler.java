package httpserver.route.requestmethod;

import httpserver.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.Response;
import httpserver.http.response.ResponseFactory;

public class OptionsMethodHandler extends MethodHandler {

    public Response getResponse(Request request) {
        var requestPath = request.getRequestPath();

        switch (requestPath) {
            case "/method_options":
                return ResponseFactory.build(StatusCode.OK, "Allow", "GET, HEAD, OPTIONS", null);
            case "/method_options2":
                return ResponseFactory.build(StatusCode.OK, "Allow", "GET, HEAD, OPTIONS, PUT, POST", null);
            default:
                return ResponseFactory.build(StatusCode.NOT_FOUND, null, null, null);
        }
    }
}
