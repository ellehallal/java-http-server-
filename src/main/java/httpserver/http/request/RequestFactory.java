package httpserver.http.request;

public class RequestFactory {
    public static Request build(String rawRequest) {
        var requestParser = new RequestParser(rawRequest);

        return new Request()
                .setRequestMethod(requestParser.getRequestMethod())
                .setRequestPath(requestParser.getRequestPath())
                .setRequestHeaders(requestParser.getRequestHeaders())
                .setRequestBody(requestParser.getRequestBody());
    }
}
