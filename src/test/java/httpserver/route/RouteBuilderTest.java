package httpserver.route;

import httpserver.RequestMethod;
import httpserver.StatusCode;
import httpserver.http.response.ResponseBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RouteBuilderTest {
    private MethodHandler methodHandler = (request) -> ResponseBuilder.build(
            StatusCode.OK, null, null, request.getRequestBody());

    @Test
    void createsARouteInstanceWithRequestMethodPathAndAMethodHandler() {
        var route = RouteBuilder.build(
                RequestMethod.GET, "/simple_get", methodHandler);

        assertEquals(route.getRequestMethod(), RequestMethod.GET);
        assertEquals(route.getPath(), "/simple_get");
        assertNotNull(route.getMethodHandler());
    }
}