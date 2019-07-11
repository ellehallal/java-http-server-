package httpServer;

import java.io.IOException;

class ReadResponseException extends RuntimeException {

    ReadResponseException(Exception cause) {
        super(cause);
    }
}
