package httpServer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void hello() {
        var hello = new App();
        var greeting = hello.hello();

        assertEquals("Hello world", greeting);
    }
}