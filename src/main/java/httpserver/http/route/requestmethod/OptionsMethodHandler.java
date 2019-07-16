package httpserver.http.route.requestmethod;

import httpserver.http.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.ResponseFactory;

public class OptionsMethodHandler extends MethodHandler {

    public String getResponse(Request request) {
        var requestPath = request.getRequestPath();
        switch (requestPath) {
            case "/method_options":
                return buildResponseString(StatusCode.OK, "Allow", "GET, HEAD, OPTIONS");
            case "/method_options2":
                return buildResponseString(StatusCode.OK, "Allow", "GET, HEAD, OPTIONS, PUT, POST");
            default:
                return buildResponseString(StatusCode.NOT_FOUND, null, null);
        }
    }
}
