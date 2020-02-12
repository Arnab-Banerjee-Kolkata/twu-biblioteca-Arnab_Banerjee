import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ConsoleTest {
    Console console;

    @BeforeEach
    void setup() {
        console = new Console(System.out);
    }

    @Test
    void shouldReadInputFromConsumer() throws IOException {
        String simulatedInput = "Name: ThoughtWorks";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        String expectedValue = "Name: ThoughtWorks";

        String actualValue = console.readLine();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void shouldPrintToConsumer() {
        PrintStream printStream = mock(PrintStream.class);
        console = new Console(printStream);

        console.print("Name: ThoughtWorks");

        verify(printStream, times(1)).print("Name: ThoughtWorks");
    }
}