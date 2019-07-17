package httpserver.http.route.requestmethod;

import httpserver.http.StatusCode;
import httpserver.http.request.Request;

public class OptionsMethodHandler extends MethodHandler {

    public String getResponse(Request request) {
        var requestPath = request.getRequestPath();
        switch (requestPath) {
            case "/method_options":
                return getResponseString(StatusCode.OK, "Allow", "GET, HEAD, OPTIONS");
            case "/method_options2":
                return getResponseString(StatusCode.OK, "Allow", "GET, HEAD, OPTIONS, PUT, POST");
            default:
                return getResponseString(StatusCode.NOT_FOUND, null, null);
        }
    }
}
