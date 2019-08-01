package httpserver.route;

import httpserver.RequestMethod;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoutesTest {
    @Test
    void addsARouteObject() {

        var methodHandler = new FakeMethodHandler();
        var routes = new Routes();
        var route = RouteBuilder.build(RequestMethod.GET, "/simple_get", methodHandler);

        routes.addRoute(route);
        var allRoutes = routes.getRoutes();

        assertEquals(1, allRoutes.size());
        assertEquals(RequestMethod.GET, allRoutes.get("/simple_get").get(0).getRequestMethod());
        assertEquals("/simple_get", allRoutes.get("/simple_get").get(0).getPath());
        assertEquals(methodHandler, allRoutes.get("/simple_get").get(0).getMethodHandler());
    }
}