package httpserver;

import httpserver.http.request.ReadRequestException;
import httpserver.server.*;

class ExceptionHandler {

    static void handleException(Exception exception) {
        if (exception instanceof ClientInputOutputException) {
            ConsoleWriter.println
                    (Messages.clientInputOutputExceptionMessage() + exception.getMessage());
        } else if (exception instanceof ClientSocketException) {
            ConsoleWriter.println
                    (Messages.clientSocketExceptionMessage() + exception.getMessage());
        } else if (exception instanceof ClientCloseConnectionException) {
            ConsoleWriter.println
                    (Messages.clientCloseConnectionExceptionMessage() + exception.getMessage());
        } else if (exception instanceof ReadRequestException) {
            ConsoleWriter.println
                    (Messages.readRequestExceptionMessage() + exception.getMessage());
        }
    }
}
