package httpserver.http.route.requestmethod;

import httpserver.http.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.ResponseFactory;

public abstract class MethodHandler {
    public abstract String getResponse(Request request);

    String getResponseString(StatusCode statusCode, String headerName, String headerValue, String body) {
        var response = ResponseFactory.build(statusCode, headerName, headerValue, body);
        return response.toString();
    }
}
