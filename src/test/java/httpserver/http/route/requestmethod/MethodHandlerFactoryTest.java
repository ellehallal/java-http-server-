package httpserver.http.route.requestmethod;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MethodHandlerFactoryTest {
    @Test
    void returnsAnInstanceOfGetMethodHandlerWhenTheMethodIsGet() {
        var methodHandler = MethodHandlerFactory.getHandler("GET");

        assertThat(methodHandler).isInstanceOf(GetMethodHandler.class);
    }

    @Test
    void returnsAnInstanceOfOptionsMethodHandlerWhenTheMethodIsOptions() {
        var methodHandler = MethodHandlerFactory.getHandler("OPTIONS");

        assertThat(methodHandler).isInstanceOf(OptionsMethodHandler.class);
    }

    @Test
    void returnsAnInstanceOfHeadMethodHandlerWhenTheMethodIsHead() {
        var methodHandler = MethodHandlerFactory.getHandler("HEAD");

        assertThat(methodHandler).isInstanceOf(HeadMethodHandler.class);
    }

    @Test
    void returnsAnInstanceOfUnknownMethodHandlerWhenTheMethodIsNotADeclaredRequestMethod() {
        var methodHandler = MethodHandlerFactory.getHandler("PUT");

        assertThat(methodHandler).isInstanceOf(UnknownMethodHandler.class);
    }
}
