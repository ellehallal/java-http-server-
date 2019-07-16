package httpserver.http.route.requestmethod;

import httpserver.http.StatusCode;
import httpserver.http.response.ResponseBuilder;

public class OptionsMethodHandler extends ResponseBuilder {

    public String getResponse(String requestPath) {
        switch (requestPath) {
            case "/method_options":
                return ResponseBuilder.buildResponse
                        (StatusCode.OK, "Allow: GET, HEAD, OPTIONS");
            case "/method_options2":
                return ResponseBuilder.buildResponse
                        (StatusCode.OK, "Allow: GET, HEAD, OPTIONS, PUT, POST");
            default:
                return ResponseBuilder.buildResponse(StatusCode.NOT_FOUND, null);
        }
    }
}
