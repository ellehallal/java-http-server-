package httpserver.http.route.requestmethod;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MethodHandlerFactoryTest {
    @Test
    void returnsAnInstanceOfGetMethodHandlerWhenTheMethodIsGet() {
        var methodHandler = MethodHandlerFactory.getHandler("GET");
        assertThat(methodHandler instanceof GetMethodHandler);
    }

    @Test
    void returnsAnInstanceOfOptionsMethodHandlerWhenTheMethodIsOptions() {
        var methodHandler = MethodHandlerFactory.getHandler("OPTIONS");
        assertThat(methodHandler instanceof OptionsMethodHandler);
    }

    @Test
    void returnsAnInstanceOfHeadMethodHandlerWhenTheMethodIsHead() {
        var methodHandler = MethodHandlerFactory.getHandler("HEAD");
        assertThat(methodHandler instanceof HeadMethodHandler);
    }
}
