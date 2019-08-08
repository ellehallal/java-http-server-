package httpserver.route;

import httpserver.RequestMethod;
import httpserver.StatusCode;
import httpserver.http.request.Request;
import httpserver.http.response.Response;
import httpserver.http.response.ResponseBuilder;

public class RouteHandler {
    private final Routes routes;

    public RouteHandler(Routes routes) {
        this.routes = routes;
    }

    public Response getResponse(Request request) {
        if(isRequestMethodInvalid(request)) {
            return createBadRequestResponse();

        } else if(isRequestPathInvalid(request)) {
            return createNotFoundResponse();

        } else if(isRequestMethodInvalidForPath(request)) {
            return createMethodNotAllowedResponse(request);

        } else if(isOptionsRequest(request)) {
            return createOptionsResponse(request);

        }  else {
            return getRouteHandler(request);
        }
    }

    private boolean isRequestMethodInvalid(Request request) {
        var requestMethod = RequestMethod.valueOf(request.getRequestMethod());

        return requestMethod == RequestMethod.INVALID;
    }

    private Response createBadRequestResponse() {
        return ResponseBuilder.build(
                StatusCode.BAD_REQUEST, null, null, null);
    }

    private boolean isRequestPathInvalid(Request request) {
        return !routes.isValidPath(request.getRequestPath());
    }

    private Response createNotFoundResponse() {
        return ResponseBuilder.build(
                StatusCode.NOT_FOUND, null, null, null);
    }

    private boolean isRequestMethodInvalidForPath(Request request) {
        var requestPath = request.getRequestPath();
        var requestMethod = RequestMethod.valueOf(request.getRequestMethod());

        return !routes.doesRouteExist(requestPath, requestMethod);
    }

    private Response createMethodNotAllowedResponse(Request request) {
        var requestPath = request.getRequestPath();
        var validRequestMethods = routes.getValidMethods(requestPath);

        return ResponseBuilder.build(
                StatusCode.METHOD_NOT_ALLOWED, "Allow", validRequestMethods, null);
    }

    private boolean isOptionsRequest(Request request) {
        var requestMethod = RequestMethod.valueOf(request.getRequestMethod());

        return requestMethod == RequestMethod.OPTIONS;
    }

    private Response createOptionsResponse(Request request) {
        var requestPath = request.getRequestPath();
        var validRequestMethods = routes.getValidMethods(requestPath);

        return ResponseBuilder.build(
                StatusCode.OK, "Allow", validRequestMethods, null);
    }

    private Response getRouteHandler(Request request) {
        var requestPath = request.getRequestPath();
        var requestMethod = RequestMethod.valueOf(request.getRequestMethod());
        var route = routes.getASingleRoute(requestPath, requestMethod);

        return route.getMethodHandler().handle(request);
    }
}
