package httpserver.route.method;

import httpserver.http.request.Request;
import httpserver.http.response.Response;

@FunctionalInterface
public interface MethodHandler {
    Response handle(Request request, Response response);
}
