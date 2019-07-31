package httpserver.route.method;

import httpserver.http.request.Request;
import httpserver.http.response.Response;

public abstract class MethodHandler {
    public abstract Response getResponse(Request request);
}
