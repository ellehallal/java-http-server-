package httpServer;

public class RequestSplitter {
    public RequestSplitter(String request) {
        this.request = request;
    }

    private final String request;

    String getRequestMethod() {
        var splitRequest = splitRequestLine();
        return splitRequest[0];
    }

    String getRequestPath() {
        var splitRequest = splitRequestLine();
        return splitRequest[1];
    }

    private String[] splitRequestLine() {
        return request.split(" ");
    }
}
