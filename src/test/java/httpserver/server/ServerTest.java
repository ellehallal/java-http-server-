package httpserver.server;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class ServerTest {

    @Test
    void returnsOutputOfServer() throws IOException {

        var fakeServerSocket = new FakeServerSocket();
        var executor = new CurrentThreadExecutor();
        var server = new Server(fakeServerSocket, executor);

        server.listenForClient();

        assertThat(fakeServerSocket.getClientSocketOutputString()).contains("HTTP/1.1 200 OK");
    }

}
