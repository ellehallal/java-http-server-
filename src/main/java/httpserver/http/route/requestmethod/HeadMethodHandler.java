package httpserver.http.route.requestmethod;

import httpserver.http.StatusCode;
import httpserver.http.request.Request;

public class HeadMethodHandler extends MethodHandler {

    @Override
    public String getResponse(Request request) {
        var requestPath = request.getRequestPath();
        switch (requestPath) {
            case "/get_with_body":
                return buildResponseString(StatusCode.OK, null, null);
            default:
                return buildResponseString(StatusCode.NOT_FOUND, null, null);
        }
    }
}
