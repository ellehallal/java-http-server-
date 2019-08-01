package httpserver.route;

import httpserver.RequestMethod;

public class Route {
    private RequestMethod requestMethod;
    private String path;
    private MethodHandler methodHandler;


    public Route setRequestMethod(RequestMethod requestMethod) {
        this.requestMethod = requestMethod;
        return this;
    }

    public Route setPath(String path) {
        this.path = path;
        return this;
    }

    public Route setMethodHandler(MethodHandler methodHandler) {
        this.methodHandler = methodHandler;
        return this;
    }

    public String getPath() {
        return path;
    }

    public MethodHandler getMethodHandler() {
        return methodHandler;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }
}
