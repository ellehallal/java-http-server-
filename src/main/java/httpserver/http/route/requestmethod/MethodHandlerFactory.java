package httpserver.http.route.requestmethod;

import httpserver.http.RequestMethod;

public class MethodHandlerFactory {

    public static MethodHandler getHandler(String clientRequestMethod) {
        if (isRequestMethodValid(clientRequestMethod)) {
            return selectHandlerType(clientRequestMethod);
        } else {
            return new UnknownMethodHandler();
        }
    }

    private static boolean isRequestMethodValid(String clientRequestMethod) {
        return RequestMethodValidator.isRequestMethodValid(clientRequestMethod);
    }

    private static MethodHandler selectHandlerType(String clientRequestMethod) {
        var requestMethod = RequestMethod.valueOf(clientRequestMethod);
        switch (requestMethod) {
            case GET:
                return new GetMethodHandler();
            case POST:
                return new PostMethodHandler();
            case OPTIONS:
                return new OptionsMethodHandler();
            case HEAD:
                return new HeadMethodHandler();
            case INVALID:
                return new InvalidMethodHandler();
            default:
                return new UnknownMethodHandler();
        }
    }
}
