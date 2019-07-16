package httpserver.http.route.requestmethod;

import httpserver.http.StatusCode;
import httpserver.http.request.Request;

public class HeadMethodHandler extends MethodHandler {

    @Override
    public String getResponse(Request request) {
        var requestPath = request.getRequestPath();
        switch (requestPath) {
            case "/simple_get":
            case "/get_with_body":
                return getResponseString(StatusCode.OK, null, null);
            default:
                return getResponseString(StatusCode.NOT_FOUND, null, null);
        }
    }
}
