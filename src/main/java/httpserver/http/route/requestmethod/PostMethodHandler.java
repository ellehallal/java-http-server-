package httpserver.http.route.requestmethod;

import httpserver.http.StatusCode;
import httpserver.http.request.Request;

public class PostMethodHandler extends MethodHandler {

    @Override
    public String getResponse(Request request) {
        var requestPath = request.getRequestPath();
        switch (requestPath) {
            case "/echo_body":
                return getResponseString(StatusCode.OK, null, null, "hello");
            default:
                return getResponseString(StatusCode.NOT_FOUND, null, null, null);
        }
    }
}
