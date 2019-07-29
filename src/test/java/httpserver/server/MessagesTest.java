package httpserver.server;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessagesTest {

    @Test
    void returnsClientInputOutputExceptionMessage() {
        var message = Messages.clientInputOutputExceptionMessage();

        assertEquals("Client input/output exception ", message);
    }

    @Test
    void returnsClientSocketExceptionMessage() {
        var message = Messages.clientSocketExceptionMessage();

        assertEquals("Client socket exception ", message);
    }

    @Test
    void returnsClientCloseConnectionExceptionMessage() {
        var message = Messages.clientCloseConnectionExceptionMessage();

        assertEquals("Client close connection exception ", message);
    }

    @Test
    void returnsReadRequestExceptionMessage() {
        var message = Messages.readRequestExceptionMessage();

        assertEquals("Read response exception ", message);
    }

    @Test
    void returnsServerSocketExceptionMessage() {
        var message = Messages.serverSocketExceptionMessage();

        assertEquals("ServerRunner socket exception ", message);
    }
}
