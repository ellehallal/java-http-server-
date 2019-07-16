package httpserver.http.route.requestmethod;

import httpserver.http.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.ResponseFactory;

public class GetMethodHandler extends ResponseFactory {

    public String getResponse(Request request) {
        var requestPath = request.getRequestPath();

        switch (requestPath) {
            case "/simple_get":
                return buildResponseString(StatusCode.OK, null, null);
            default:
                return buildResponseString(StatusCode.NOT_FOUND, null, null);
        }
    }
    private String buildResponseString(StatusCode statusCode, String headerName, String headerValue) {
        var response = ResponseFactory.build(statusCode, headerName, headerValue);
        return response.toString();
    }
}
