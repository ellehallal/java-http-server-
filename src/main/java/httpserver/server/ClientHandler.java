package httpserver.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientHandler implements Runnable {
    private final Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        setInputAndOutput();
        sendRequestAndSendResponse();
        closeConnection();
    }

    private void setInputAndOutput() {
        try {
            var inputStreamReader = new InputStreamReader(socket.getInputStream(), "utf-8");
            input = new BufferedReader(inputStreamReader);
            output = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            throw new ClientInputOutputException(e);
        }
    }

    private void sendRequestAndSendResponse() {
        new RequestResponseHandler(input, output).run();
    }

    private void closeConnection() {
        try {
            input.close();
            output.close();
            socket.close();
            ConsoleWriter.println(ServerMessage.CLIENT_DISCONNECTED.toString());
        } catch (IOException e) {
            throw new ClientCloseConnectionException(e);
        }
    }
}
