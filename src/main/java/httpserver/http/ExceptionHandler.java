package httpserver.http;

import httpserver.server.ClientInputOutputException;
import httpserver.server.ClientSocketException;
import httpserver.server.ConsoleWriter;
import httpserver.server.Messages;

public class ExceptionHandler {
    private final Exception exception;

    public ExceptionHandler(Exception exception) {
        this.exception = exception;
    }

    public void handleException() {
        if (exception instanceof ClientInputOutputException) {
            ConsoleWriter.println
                    (Messages.clientInputOutputExceptionMessage() + exception.getMessage());
        } else if (exception instanceof ClientSocketException) {
            ConsoleWriter.println
                    (Messages.clientSocketExceptionMessage() + exception.getMessage());
        } else if (exception instanceof ReadResponseException) {
            ConsoleWriter.println
                    (Messages.readResponseExceptionMessage() + exception.getMessage());
        }
    }
}
