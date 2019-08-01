package httpserver.route;

import httpserver.RequestMethod;
import httpserver.StatusCode;
import httpserver.http.request.Request;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RouteHandlerTest {
    @Test
    void returns200StatusWithNoHeadersAndEmptyBodyWhenRequestPathIsSimpleGet() {
        var methodHandler = new FakeMethodHandler();
        var routes = new Routes();
        routes.addRoute(RouteBuilder.build(RequestMethod.GET, "/simple_get", methodHandler));
        var request = new Request()
                .setRequestMethod("GET")
                .setRequestPath("/simple_get");
        var routeHandler = new RouteHandler(routes);

        var response = routeHandler.getResponse(request);

        assertEquals("HTTP/1.1 200 OK\r\n\r\n", response.toString());
    }

    @Test
    void returnsStatusCode200WhenTheRequestMethodIsHeadAndPathIsSimpleGet() {
        var methodHandler = new FakeMethodHandler();
        var routes = new Routes();
        routes.addRoute(RouteBuilder.build(RequestMethod.HEAD, "/simple_get", methodHandler));
        var request = new Request()
                .setRequestMethod("HEAD")
                .setRequestPath("/simple_get");
        var routeHandler = new RouteHandler(routes);

        var response = routeHandler.getResponse(request);

        assertEquals("HTTP/1.1 200 OK\r\n\r\n", response.toString());
    }


    @Test
    void returns200StatusWithAllowHeaderWhenRequestMethodIsOptionsAndPathIsMethodOptions() {
        var methodHandler = new FakeMethodHandler();
        var routes = new Routes();
        routes.addRoute(RouteBuilder.build(RequestMethod.GET, "/method_options", methodHandler));
        routes.addRoute(RouteBuilder.build(RequestMethod.HEAD, "/method_options", methodHandler));
        routes.addRoute(RouteBuilder.build(RequestMethod.OPTIONS, "/method_options", methodHandler));
        var request = new Request()
                .setRequestMethod("OPTIONS")
                .setRequestPath("/method_options");
        var routeHandler = new RouteHandler(routes);

        var response = routeHandler.getResponse(request);

        assertEquals("HTTP/1.1 200 OK\r\n"
                + "Allow: GET, HEAD, OPTIONS\r\n\r\n", response.toString());
    }

    @Test
    void returns200StatusWithAllowHeaderWhenRequestMethodIsOptionsAndPathIsMethodOptions2() {
        var methodHandler = new FakeMethodHandler();
        var routes = new Routes();
        routes.addRoute(RouteBuilder.build(RequestMethod.GET, "/method_options2", methodHandler));
        routes.addRoute(RouteBuilder.build(RequestMethod.HEAD, "/method_options2", methodHandler));
        routes.addRoute(RouteBuilder.build(RequestMethod.OPTIONS, "/method_options2", methodHandler));
        routes.addRoute(RouteBuilder.build(RequestMethod.PUT, "/method_options2", methodHandler));
        routes.addRoute(RouteBuilder.build(RequestMethod.POST, "/method_options2", methodHandler));
        var request = new Request()
                .setRequestMethod("OPTIONS")
                .setRequestPath("/method_options2");
        var routeHandler = new RouteHandler(routes);

        var response = routeHandler.getResponse(request);

        assertEquals("HTTP/1.1 200 OK\r\n"
                + "Allow: GET, HEAD, OPTIONS, PUT, POST\r\n\r\n", response.toString());
    }

    @Test
    void returnsStatusCode405AndAllowHeaderWhenRequestMethodIsGetAndPathIsGetWithBody() {
        var methodHandler = new FakeMethodHandler();
        var routes = new Routes();
        routes.addRoute(RouteBuilder.build(RequestMethod.HEAD, "/get_with_body", methodHandler));
        routes.addRoute(RouteBuilder.build(RequestMethod.OPTIONS, "/get_with_body", methodHandler));
        var request = new Request()
                .setRequestMethod("GET")
                .setRequestPath("/get_with_body");
        var routeHandler = new RouteHandler(routes);

        var response = routeHandler.getResponse(request);

        assertEquals("HTTP/1.1 405 METHOD NOT ALLOWED\r\n"
                + "Allow: HEAD, OPTIONS\r\n\r\n", response.toString());
    }

    @Test
    void returnsStatusCode200WhenTheRequestMethodIsHeadAndPathIsGetWithBody() {
        var methodHandler = new FakeMethodHandler();
        var routes = new Routes();
        routes.addRoute(RouteBuilder.build(RequestMethod.HEAD, "/get_with_body", methodHandler));
        var request = new Request()
                .setRequestMethod("HEAD")
                .setRequestPath("/get_with_body");
        var routeHandler = new RouteHandler(routes);

        var response = routeHandler.getResponse(request);

        assertEquals("HTTP/1.1 200 OK\r\n\r\n", response.toString());
    }

    @Test
    void returnsStatusCode301WhenTheRequestMethodIsGetAndPathIsRedirect() {
        var requestHeaders = new HashMap<String, String>();
        requestHeaders.put("Host", "localhost:5000");
        var fakeRequest = new Request()
                .setRequestMethod("GET")
                .setRequestPath("/redirect")
                .setRequestHeaders(requestHeaders);
        var routes = new Routes();
        routes.addRoute(RouteBuilder.build(RequestMethod.GET, "/redirect", (request, response) -> {
                    response.setStatusCode(StatusCode.MOVED_PERMANENTLY)
                            .setHeaders("Location", URIFactory.build(request, "/simple_get").toString());
                    return response;
                }));
        var routeHandler = new RouteHandler(routes);

        var response = routeHandler.getResponse(fakeRequest);

        assertEquals("HTTP/1.1 301 MOVED PERMANENTLY\r\n"
                + "Location: http://localhost:5000/simple_get\r\n\r\n", response.toString());
    }

    @Test
    void returnsStatusCode200WithHeadersAndRequestBodyWhenPathIsEchoBody() {
        var routes = new Routes();
        routes.addRoute(RouteBuilder.build(RequestMethod.POST, "/echo_body",
                (request, response) -> {
                    response.setBody(request.getRequestBody());
                    return response;
                }));
        var request = new Request()
                .setRequestMethod("POST")
                .setRequestPath("/echo_body")
                .setRequestBody("hi");
        var routeHandler = new RouteHandler(routes);

        var response = routeHandler.getResponse(request);

        assertEquals("HTTP/1.1 200 OK\r\n\r\n" + "hi", response.toString());
    }

    @Test
    void returns404StatusWhenPathDoesNotExist() {
        var routes = new Routes();
        var request = new Request()
                .setRequestMethod("GET")
                .setRequestPath("/some_path");
        var routeHandler = new RouteHandler(routes);

        var response = routeHandler.getResponse(request);

        assertEquals("HTTP/1.1 404 NOT FOUND\r\n\r\n", response.toString());
    }

    @Test
    void returnsWith400StatusWhenRequestIsInvalid() {
        var routes = new Routes();
        var request = new Request()
                .setRequestMethod("INVALID")
                .setRequestPath("/some_path");
        var routeHandler = new RouteHandler(routes);

        var response = routeHandler.getResponse(request);

        assertEquals("HTTP/1.1 400 BAD REQUEST\r\n\r\n", response.toString());
    }
}