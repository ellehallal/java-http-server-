package httpserver.route.requestmethod;

import httpserver.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.Response;
import httpserver.http.response.ResponseFactory;

public abstract class MethodHandler {
    public abstract Response getResponse(Request request);

    Response getResponseString(StatusCode statusCode, String headerName, String headerValue, String body) {
        return ResponseFactory.build(statusCode, headerName, headerValue, body);

    }
}
