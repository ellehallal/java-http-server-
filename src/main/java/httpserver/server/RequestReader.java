package httpserver.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class RequestReader {
    private final BufferedReader input;
    private final StringBuilder request = new StringBuilder();
    private final String separator = "\r\n";

    public RequestReader(BufferedReader input) {
        this.input = input;
    }

    public String read() {
        readRequestLineAndHeaders();
        readRequestBody();
        return convertRequestToString();
    }

    private void readRequestLineAndHeaders() {
        String line;

        try {
            while ((line = input.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                }

                addToRequest(line.trim());
                addToRequest(separator);
            }
        } catch (IOException e) {
            throw new ReadRequestException(e);
        }
    }

    private void readRequestBody() {
        ArrayList<Byte> list = getRequestBodyBytes();
        var bodyString = convertBodyBytesToString(list);

        if(bodyString.length() > 0) {
            addToRequest(separator);
            addToRequest(bodyString);
        }
    }

    private ArrayList<Byte> getRequestBodyBytes() {
        ArrayList<Byte> list = new ArrayList<>();
        int bodyByte;

        try {
            while (input.ready() && (bodyByte = input.read()) != -1) {
                list.add((byte) bodyByte);
            }
        } catch (IOException e) {
            throw new ReadRequestException(e);
        }
        return list;
    }

    private String convertBodyBytesToString(ArrayList<Byte> list) {
        byte[] byteArray = new byte[list.size()];

        for(int i = 0; i < list.size(); i++) {
            byteArray[i] = list.get(i);
        }

        return new String(byteArray);
    }

    private void addToRequest(String string) {
        request.append(string);
    }

    private String convertRequestToString() {
        return request.toString();
    }
}
