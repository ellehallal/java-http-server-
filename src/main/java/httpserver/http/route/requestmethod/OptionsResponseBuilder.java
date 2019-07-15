package httpserver.http.route.requestmethod;

import httpserver.http.StatusCode;

public class OptionsResponseBuilder extends ResponseBuilder {

    public String getResponse(String requestPath) {
        switch (requestPath) {
            case "/method_options":
                return buildResponse(StatusCode.OK, "Allow: GET, HEAD, OPTIONS");
            case "/method_options2":
                return buildResponse(StatusCode.OK, "Allow: GET, HEAD, OPTIONS, PUT, POST");
            default:
                return buildNotFoundResponse();
        }
    }
}
