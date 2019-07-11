package httpServer;

public class RequestSplitter {

    static String getRequestMethod(String request) {
        var splitRequest = splitRequestLine(request);
        return splitRequest[0];
    }

    static String getRequestPath(String request) {
        var splitRequest = splitRequestLine(request);
        return splitRequest[1];
    }

    private static String[] splitRequestLine(String request) {
        return request.split(" ");
    }
}
