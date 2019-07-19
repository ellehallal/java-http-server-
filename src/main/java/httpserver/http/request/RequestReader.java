package httpserver.http.request;

import java.io.BufferedReader;
import java.io.IOException;

public class RequestReader {

    public static String read(BufferedReader input) {
        StringBuilder request = new StringBuilder();
        String requestLine;

        try {
            while ((requestLine = input.readLine()) != null) {
                request.append(requestLine.trim());
                request.append("\r\n");

                if (requestLine.isEmpty()) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new ReadRequestException(e);
        }
        return request.toString().strip();
    }
}
