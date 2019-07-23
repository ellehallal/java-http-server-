package httpserver.server;

import httpserver.http.response.Response;

public class ResponseParser {

    public static String parse(Response response) {
        return response.toString();
    }
}
