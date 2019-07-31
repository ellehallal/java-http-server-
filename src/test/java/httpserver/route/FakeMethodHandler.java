package httpserver.route;

import httpserver.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.Response;
import httpserver.http.response.ResponseFactory;
import httpserver.route.method.MethodHandler;

public class FakeMethodHandler extends MethodHandler {

    @Override
    public Response getResponse(Request request) {
        return ResponseFactory.build(StatusCode.OK, null, null, null);
    }
}
