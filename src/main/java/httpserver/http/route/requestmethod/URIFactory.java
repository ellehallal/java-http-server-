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

    public static URI build(String hostAddress, Integer port, String path) {
        return new URI()
                .setHostAddress(hostAddress)
                .setPort(port)
                .setPath(path);
    }

    public static URI build(Integer port, String path) {
        return new URI()
                .setPort(port)
                .setPath(path);
    }
}
