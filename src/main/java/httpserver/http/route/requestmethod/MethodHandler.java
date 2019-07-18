package httpserver.http.route.requestmethod;

import httpserver.http.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.ResponseFactory;

import java.net.InetAddress;

public abstract class MethodHandler {
    public abstract String getResponse(Request request);

    String getResponseString(StatusCode statusCode, String headerName, String headerValue) {
        var response = ResponseFactory.build(statusCode, headerName, headerValue);
        return response.toString();
    }

    String getHostAddress() {
        return InetAddress.getLoopbackAddress().getHostAddress();
    }
}
