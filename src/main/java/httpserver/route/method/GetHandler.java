package httpserver.route.method;

import httpserver.http.request.Request;
import httpserver.http.response.Response;

public class GetHandler implements MethodHandler {
    @Override
    public Response handle(Request request, Response response) {
        return response;
    }
}
