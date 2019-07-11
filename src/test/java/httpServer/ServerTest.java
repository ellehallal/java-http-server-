package httpServer;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class ServerTest {

    @Test
    void returnsOutputOfServer() throws IOException {

        var fakeServerSocket = new FakeServerSocket();
        var server = new Server(fakeServerSocket);

        server.listenForClient();

        assertThat(fakeServerSocket.getClientSocketOutputString()).contains("HTTP/1.1 200 OK");
    }

}