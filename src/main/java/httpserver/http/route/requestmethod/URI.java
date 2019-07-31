package httpserver.http.route.requestmethod;

import httpserver.http.request.Request;

public class URI {
    private final Request request;
    private String protocol = "http";
    private String hostAddress;
    private int port;
    private String path;

    public URI(Request request) {
        this.request = request;
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

    private String getHost() {
        var requestHeaders = request.getRequestHeaders();
        return requestHeaders.get("Host").toString();
    }

    public URI setHostAddress() {
        var hostHeader = getHost();
        hostAddress = hostHeader.split(":")[0];
        return this;
    }

    public URI setPort() {
        var hostHeader = getHost();
        port = Integer.parseInt(hostHeader.split(":")[1]);
        return this;
    }
}
