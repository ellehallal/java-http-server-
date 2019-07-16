package httpserver.http.route.requestmethod;

import httpserver.http.StatusCode;
import httpserver.http.response.ResponseFactory;

public class OptionsMethodHandler {

    public String getResponse(String requestPath) {
        switch (requestPath) {
            case "/method_options":
                return buildResponseString(StatusCode.OK, "Allow",  "GET, HEAD, OPTIONS");
            case "/method_options2":
                return buildResponseString(StatusCode.OK, "Allow", "GET, HEAD, OPTIONS, PUT, POST");
            default:
                return buildResponseString(StatusCode.NOT_FOUND, null, null);
        }
    }

    private String buildResponseString(StatusCode statusCode, String headerName, String headerValue) {
        var response = ResponseFactory.build(statusCode, headerName, headerValue);
        return response.toString();
    }
}
