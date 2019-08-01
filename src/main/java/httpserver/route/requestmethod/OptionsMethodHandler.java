package httpserver.route.requestmethod;

import httpserver.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.Response;
import httpserver.http.response.ResponseBuilder;

public class OptionsMethodHandler extends MethodHandler {

    public Response getResponse(Request request) {
        var requestPath = request.getRequestPath();

        switch (requestPath) {
            case "/method_options":
                return ResponseBuilder.build(StatusCode.OK, "Allow", "GET, HEAD, OPTIONS", null);
            case "/method_options2":
                return ResponseBuilder.build(StatusCode.OK, "Allow", "GET, HEAD, OPTIONS, PUT, POST", null);
            default:
                return ResponseBuilder.build(StatusCode.NOT_FOUND, null, null, null);
        }
    }
}
