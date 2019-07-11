package httpserver.server;

import java.util.concurrent.Executor;

public class CurrentThreadExecutor implements Executor {
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
