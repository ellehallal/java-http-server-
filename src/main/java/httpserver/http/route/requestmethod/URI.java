package httpserver.http.route.requestmethod;

import java.net.InetAddress;

public class URI {
    private String protocol;
    private String hostAddress;
    private Integer port;
    private String path;
    private final String defaultHostAddress
            = InetAddress.getLoopbackAddress().getHostAddress();

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
                + getHostAddress()
                + getPort()
                + getPath();
    }

    private String getProtocol() {
        return protocol == null ?  "http://" : protocol;
    }

    private String getHostAddress() {
        return hostAddress == null ? defaultHostAddress : hostAddress;
    }

    private String getPort() {
        return port == null ?  "" : ":" + port;
    }

    private String getPath() {
        return path == null ?  "" :  path;
    }
}
