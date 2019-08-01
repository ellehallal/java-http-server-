package httpserver.route;

import httpserver.RequestMethod;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoutesTest {
    @Test
    void addsARouteObjectToANewPath() {

        var methodHandler = new FakeMethodHandler();
        var routes = new Routes();
        var route = RouteBuilder.build(RequestMethod.GET, "/simple_get", methodHandler);

        routes.addRoute(route);
        var allRoutes = routes.getPathsAndRoutes();
        var getSimpleGetRoute = routes.getASingleRoute("/simple_get", RequestMethod.GET);

        assertEquals(1, allRoutes.size());
        assertEquals(RequestMethod.GET, getSimpleGetRoute.getRequestMethod());
        assertEquals("/simple_get", getSimpleGetRoute.getPath());
        assertEquals(methodHandler, getSimpleGetRoute.getMethodHandler());
    }

    @Test
    void addsARouteObjectToAnExistingPath() {

        var methodHandler = new FakeMethodHandler();
        var routes = new Routes();
        var getSimpleGetRoute = RouteBuilder.build(RequestMethod.GET, "/simple_get", methodHandler);
        var postSimpleGetRoute = RouteBuilder.build(RequestMethod.POST, "/simple_get", methodHandler);

        routes.addRoute(getSimpleGetRoute);
        routes.addRoute(postSimpleGetRoute);
        var allRoutes = routes.getPathsAndRoutes();
        var getRoute = routes.getASingleRoute("/simple_get", RequestMethod.GET);
        var postRoute = routes.getASingleRoute("/simple_get", RequestMethod.POST);

        assertEquals(1, allRoutes.size());
        assertEquals(2, allRoutes.get("/simple_get").size());
        assertEquals(RequestMethod.GET, getRoute.getRequestMethod());
        assertEquals("/simple_get", getRoute.getPath());
        assertEquals(methodHandler, getRoute.getMethodHandler());
        assertEquals(RequestMethod.POST, postRoute.getRequestMethod());
        assertEquals("/simple_get", postRoute.getPath());
        assertEquals(methodHandler, postRoute.getMethodHandler());
    }

    @Test
    void ifRouteExistsItIsNotAddedToRoutes() {

        var methodHandler = new FakeMethodHandler();
        var routes = new Routes();
        var getSimpleGetRoute1 = RouteBuilder.build(RequestMethod.GET, "/simple_get", methodHandler);
        var getSimpleGetRoute2 = RouteBuilder.build(RequestMethod.GET, "/simple_get", methodHandler);

        routes.addRoute(getSimpleGetRoute1);
        routes.addRoute(getSimpleGetRoute2);
        var allRoutes = routes.getPathsAndRoutes();

        assertEquals(1, allRoutes.size());
        assertEquals(1, allRoutes.get("/simple_get").size());
    }
}