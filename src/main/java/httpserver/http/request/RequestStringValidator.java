package httpserver.http.request;

import httpserver.http.Protocol;
import httpserver.http.RequestMethod;

public class RequestStringValidator {

    public static String validate(String clientRequestString) {
        if(isRequestStringEmpty(clientRequestString)) {
            return invalidRequest();
        }
        return clientRequestString;
    }

    private static boolean isRequestStringEmpty(String clientRequestString) {
        return clientRequestString.isEmpty();
    }

    private static String invalidRequest() {
        var requestMethod = RequestMethod.INVALID.toString();
        var path = "/";
        var protocol = Protocol.HTTP_1_1.getVersion();
        return requestMethod
                + " "
                + path
                + " "
                + protocol;
    }
}
