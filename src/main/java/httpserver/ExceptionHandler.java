package httpserver;

import httpserver.http.request.ReadRequestException;
import httpserver.server.ClientInputOutputException;
import httpserver.server.ClientSocketException;
import httpserver.server.ConsoleWriter;
import httpserver.server.Messages;

class ExceptionHandler {

    static void handleException(Exception exception) {
        if (exception instanceof ClientInputOutputException) {
            ConsoleWriter.println
                    (Messages.clientInputOutputExceptionMessage() + exception.getMessage());
        } else if (exception instanceof ClientSocketException) {
            ConsoleWriter.println
                    (Messages.clientSocketExceptionMessage() + exception.getMessage());
        } else if (exception instanceof ReadRequestException) {
            ConsoleWriter.println
                    (Messages.readResponseExceptionMessage() + exception.getMessage());
        }
    }
}
