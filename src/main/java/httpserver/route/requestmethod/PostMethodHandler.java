package httpserver.route.requestmethod;

import httpserver.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.Response;
import httpserver.http.response.ResponseFactory;

public class PostMethodHandler extends MethodHandler {

    @Override
    public Response getResponse(Request request) {
        var requestPath = request.getRequestPath();
        var requestBody = request.getRequestBody();

        switch (requestPath) {
            case "/echo_body":
                return ResponseFactory.build(StatusCode.OK, null, null, requestBody);
            default:
                return ResponseFactory.build(StatusCode.NOT_FOUND, null, null, null);
                
        }
    }
}
