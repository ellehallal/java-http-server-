package httpserver.server;

import httpserver.http.route.RouteHandler;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class ServerRunnerTest {

    @Test
    void returnsOutputOfServer() throws IOException {

        var fakeServerSocket = new FakeServerSocket();
        var executor = new CurrentThreadExecutor();
        var routeHandler = new RouteHandler();
        var server = new ServerRunner(fakeServerSocket, executor, routeHandler);

        server.listenForClient();

        assertThat(fakeServerSocket.getClientSocketOutputString()).contains("HTTP/1.1 200 OK");
    }

}
