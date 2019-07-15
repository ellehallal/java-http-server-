package httpserver.http.response;

import java.io.PrintWriter;

public class ResponseSender {
    private final PrintWriter output;

    public ResponseSender(PrintWriter output) {
        this.output = output;
    }

    public void send(String response) {
        output.println(response);
    }
}
