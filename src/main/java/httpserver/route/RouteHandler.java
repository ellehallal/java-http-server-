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
        var response = createEmptyResponse();

        if(isRequestMethodInvalid(request)) {
            return createBadRequestResponse(response);

        } else if(isRequestPathInvalid(request)) {
            return createNotFoundResponse(response);

        } else if(isRequestMethodInvalidForPath(request)) {
            return createMethodNotAllowedResponse(request, response);

        } else if(isOptionsRequest(request)) {
            return createOptionsResponse(request, response);

        }  else {
            return getRouteHandler(request, response);
        }
    }

    private Response createEmptyResponse() {
        return ResponseBuilder.build(
                StatusCode.OK, null, null, null);
    }

    private boolean isRequestMethodInvalid(Request request) {
        var requestMethod = RequestMethod.valueOf(request.getRequestMethod());

        return requestMethod == RequestMethod.INVALID;
    }

    private Response createBadRequestResponse(Response response) {
        response.setStatusCode(StatusCode.BAD_REQUEST);

        return response;
    }

    private boolean isRequestPathInvalid(Request request) {
        return !routes.isValidPath(request.getRequestPath());
    }

    private Response createNotFoundResponse(Response response) {
        return response.setStatusCode(StatusCode.NOT_FOUND);
    }

    private boolean isRequestMethodInvalidForPath(Request request) {
        var requestPath = request.getRequestPath();
        var requestMethod = RequestMethod.valueOf(request.getRequestMethod());

        return !routes.doesRouteExist(requestPath, requestMethod);
    }

    private Response createMethodNotAllowedResponse(Request request, Response response) {
        var requestPath = request.getRequestPath();
        var validRequestMethods = routes.getValidMethods(requestPath);

        return response
                .setStatusCode(StatusCode.METHOD_NOT_ALLOWED)
                .setHeaders("Allow", validRequestMethods);
    }

    private boolean isOptionsRequest(Request request) {
        var requestMethod = RequestMethod.valueOf(request.getRequestMethod());

        return requestMethod == RequestMethod.OPTIONS;
    }

    private Response createOptionsResponse(Request request, Response response) {
        var requestPath = request.getRequestPath();
        var validRequestMethods = routes.getValidMethods(requestPath);

        return response.setHeaders("Allow", validRequestMethods);
    }

    private Response getRouteHandler(Request request, Response response) {
        var requestPath = request.getRequestPath();
        var requestMethod = RequestMethod.valueOf(request.getRequestMethod());
        var route = routes.getASingleRoute(requestPath, requestMethod);

        return route.getMethodHandler().handle(request, response);
    }
}
