package httpserver.route;

import httpserver.RequestMethod;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RouteBuilderTest {
    @Test
    void createsARouteInstanceWithRequestMethodPathAndAMethodHandler() {
        var methodHandler = new FakeMethodHandler();
        var route = RouteBuilder.build(
                RequestMethod.GET, "/simple_get", methodHandler);

        assertEquals(route.getRequestMethod(), RequestMethod.GET);
        assertEquals(route.getPath(), "/simple_get");
        assertEquals(route.getMethodHandler(), methodHandler);
    }
}