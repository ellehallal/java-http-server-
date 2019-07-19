package httpserver.http.route.requestmethod;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    void returnsAnInstanceOfPostMethodHandlerWhenTheMethodIsPost() {
        var methodHandler = MethodHandlerFactory.getHandler("POST");

        assertThat(methodHandler).isInstanceOf(PostMethodHandler.class);
    }

    @Test
    void returnsAnInstanceOfUnknownMethodHandlerWhenTheMethodIsNotADeclaredRequestMethod() {
        var methodHandler = MethodHandlerFactory.getHandler("PUT");

        assertThat(methodHandler).isInstanceOf(UnknownMethodHandler.class);
    }
}
