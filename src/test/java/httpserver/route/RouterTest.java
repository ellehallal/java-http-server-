package httpserver.route;

import httpserver.RequestMethod;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RouterTest {
    @Test
    void addsARouteObject() {

        var methodHandler = new FakeMethodHandler();
        var router = new Router();
        var routes = router.getAllRoutes();
        var route = RouteBuilder.build(RequestMethod.GET, "/simple_get", methodHandler);

        router.add(route);

        assertEquals(1, routes.size());
        assertEquals(RequestMethod.GET, routes.get(0).getRequestMethod());
        assertEquals("/simple_get", routes.get(0).getPath());
        assertEquals(methodHandler, routes.get(0).getMethodHandler());
    }
}