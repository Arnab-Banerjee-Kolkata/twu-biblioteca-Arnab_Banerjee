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

    @Test
    void shouldPrintToConsumerInNewLine() {
        PrintStream printStream = mock(PrintStream.class);
        console = new Console(printStream);

        console.println("Name: ThoughtWorks");

        verify(printStream, times(1)).println("Name: ThoughtWorks");
    }

    @Test
    void shouldTakeDetailsOfBookAndReturnABook() throws IOException {
        String simulatedInput = "Book_Name_2\nAuthor_Name_2\n1987";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Book expectedBook = new Book("Book_Name_2", "Author_Name_2", 1987);

        Book actualBook = console.readBook();

        assertEquals(expectedBook, actualBook);
    }
}