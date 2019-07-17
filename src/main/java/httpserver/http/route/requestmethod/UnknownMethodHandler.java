package httpserver.http.route.requestmethod;

import httpserver.http.StatusCode;
import httpserver.http.request.Request;

public class UnknownMethodHandler extends MethodHandler {

    @Override
    public String getResponse(Request request) {
       return getResponseString(StatusCode.METHOD_NOT_ALLOWED, null, null);
    }
}
