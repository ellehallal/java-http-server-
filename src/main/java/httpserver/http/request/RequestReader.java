package httpserver.http.request;

import java.io.BufferedReader;
import java.io.IOException;

public class RequestReader {

    public static String read(BufferedReader input) {
        StringBuilder response = new StringBuilder();
        String responseLine;

        try {
            while ((responseLine = input.readLine()) != null) {
                response.append(responseLine.trim());
                response.append("\n");
            }
            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}
