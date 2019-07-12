package httpServer;

public class ExceptionHandler {
    private final Exception exception;

    public ExceptionHandler(Exception exception) {
        this.exception = exception;
    }

    void handleException() {
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
