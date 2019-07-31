package httpserver.route;

import httpserver.RequestMethod;
import httpserver.route.method.GetHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RouteBuilderTest {
    @Test
    void createsARouteInstanceWithRequestMethodPathAndAMethodHandler() {
        var getHandler = new GetHandler();
        var route = RouteBuilder.build(
                RequestMethod.GET, "/simple_get", getHandler);

        assertEquals(route.getRequestMethod(), RequestMethod.GET);
        assertEquals(route.getPath(), "/simple_get");
        assertEquals(route.getMethodHandler(), getHandler);
    }
}