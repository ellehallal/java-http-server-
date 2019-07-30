package httpserver.route.requestmethod;

import httpserver.http.request.Request;

public class URIFactory {

  public static URI build(Request request, String path) {
        return new URI(request)
                .setHostAddress()
                .setPort()
                .setPath(path);
    }
}
