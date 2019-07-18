package httpserver.http.route.requestmethod;

public class URIFactory {

    public static URI build
            (String protocol, String hostAddress, Integer port, String path) {
        return new URI()
                .setProtocol(protocol)
                .setHostAddress(hostAddress)
                .setPort(port)
                .setPath(path);
    }
}
