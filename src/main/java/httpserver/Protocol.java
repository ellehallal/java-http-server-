package httpserver;

public enum Protocol {
    HTTP_1_1("HTTP/1.1");

    private final String version;

    Protocol(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }
}
