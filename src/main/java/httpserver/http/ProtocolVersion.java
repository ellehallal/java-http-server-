package httpserver.http;

public enum ProtocolVersion {
    HTTP_1_1("HTTP/1.1");

    private final String version;

    ProtocolVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }
}
