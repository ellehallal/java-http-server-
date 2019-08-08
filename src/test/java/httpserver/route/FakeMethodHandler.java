package httpserver.route;

import httpserver.http.request.Request;
import httpserver.http.response.Response;

public class FakeMethodHandler implements MethodHandler {
    private Response response;

    public FakeMethodHandler(Response response) {
        this.response = response;
    }

    @Override
    public Response handle(Request request) {
        return response;
    }
}
