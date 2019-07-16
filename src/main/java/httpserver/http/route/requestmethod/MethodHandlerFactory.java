package httpserver.http.route.requestmethod;

import httpserver.http.RequestMethod;

public class MethodHandlerFactory {

    public static MethodHandler getHandler(String clientRequestMethod) {
        var requestMethod = RequestMethod.valueOf(clientRequestMethod);

        switch (requestMethod) {
            case GET:
                return new GetMethodHandler();
            case OPTIONS:
                return new OptionsMethodHandler();
            case HEAD:
                return new HeadMethodHandler();
            default:
                return null;
        }
    }
}
