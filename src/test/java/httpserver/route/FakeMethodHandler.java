package httpserver.route;

import httpserver.http.request.Request;
import httpserver.http.response.Response;

public class FakeMethodHandler implements MethodHandler {

    @Override
    public Response handle(Request request, Response response) {
        return response;
    }
}
