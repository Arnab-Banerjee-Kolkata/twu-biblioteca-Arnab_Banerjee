import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleTest {
    @Test
    void shouldReadInputFromConsumer() throws IOException {
        Console console = new Console();
        String simulatedInput = "Name: ThoughtWorks";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        String expectedValue = "Name: ThoughtWorks";

        String actualValue = console.readLine();

        assertEquals(expectedValue, actualValue);
    }
}