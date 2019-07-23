package httpserver.http.route.requestmethod;

import java.net.InetAddress;

public class URI {
    private String protocol = "http";
    private String hostAddress
            = InetAddress.getLoopbackAddress().getHostAddress();
    private int port = Integer.parseInt(System.getenv("PORT"));
    private String path;

    public URI setProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    public URI setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
        return this;
    }

    public URI setPort(Integer port) {
        this.port = port;
        return this;
    }

    public URI setPath(String path) {
        this.path = path;
        return this;
    }

    public String toString() {
        return getProtocol()
                + hostAddress
                + getPort()
                + getPath();
    }

    private String getProtocol() {
        return protocol + "://";
    }

    private String getPort() {
        return ":" + port;
    }

    private String getPath() {
        return path == null ?  "" :  path;
    }
}
