package httpserver.http.request;

import java.io.BufferedReader;
import java.io.IOException;

public class RequestReader {

    public static String read(BufferedReader input) {
        try {
            return input.readLine();
        } catch (IOException e) {
            throw new ReadRequestException(e);
        }
    }
}
