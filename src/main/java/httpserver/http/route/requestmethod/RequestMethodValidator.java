package httpserver.http.route.requestmethod;

import httpserver.http.RequestMethod;

public class RequestMethodValidator {

    public static boolean isRequestMethodValid(String clientRequestMethod) {
        for (RequestMethod method : RequestMethod.values())
            if (method.name().equals(clientRequestMethod)) {
                return true;
            }
        return false;
    }
}
