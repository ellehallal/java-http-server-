package httpserver.http.route.requestmethod;

import httpserver.http.StatusCode;
import httpserver.http.request.Request;

public class GetMethodHandler extends MethodHandler {

    public String getResponse(Request request) {
        var requestPath = request.getRequestPath();
        switch (requestPath) {
            case "/simple_get":
                return getResponseString(StatusCode.OK, null, null, null);
            case "/get_with_body":
                return getResponseString(StatusCode.METHOD_NOT_ALLOWED, "Allow", "HEAD, OPTIONS", null);
            case "/redirect":
                return getResponseString
                        (StatusCode.MOVED_PERMANENTLY, "Location",
                                URIFactory.build("/simple_get").toString(), null);
            default:
                return getResponseString(StatusCode.NOT_FOUND, null, null, null);
        }
    }
}
