package httpServer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FakeServerSocket extends ServerSocket {
    private Socket clientSocket;

    public FakeServerSocket() throws IOException {
    }

    @Override
    public Socket accept() {
        clientSocket = setupFakeClientSocket();
        return clientSocket;
    }

    private FakeClientSocket setupFakeClientSocket() {
        var clientMessage = "GET /simple_get HTTP/1.1";
        var input = new ByteArrayInputStream(clientMessage.getBytes());
        var output =  new ByteArrayOutputStream();
        return new FakeClientSocket(input, output);
    }

    String getClientSocketOutputString() throws IOException {
        return clientSocket.getOutputStream().toString();
    }
}
