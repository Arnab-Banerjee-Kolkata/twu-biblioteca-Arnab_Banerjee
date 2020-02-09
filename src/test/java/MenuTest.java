import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MenuTest {
    @Test
    void shouldShowMenuOptions() {
        Menu menu = Menu.getInstance();
        List<String> expectedMenuOptions = new ArrayList<>(Collections.singletonList(
                "1. Show Available Books"
        ));

        List<String> actualMenuOptions = menu.getOptions();

        assertEquals(expectedMenuOptions, actualMenuOptions);
    }

    @Test
    void shouldShowBookListIfOneIsEntered() {
        Menu menu = Menu.getInstance();
        BibliotecaApp bibliotecaApp = mock(BibliotecaApp.class);

        menu.enterOption(bibliotecaApp, 1);

        verify(bibliotecaApp, times(1)).showBooks();
    }

    @Test
    void shouldShowMessageWhenInvalidOptionIsEntered() {
        Menu menu = Menu.getInstance();
        BibliotecaApp bibliotecaApp = mock(BibliotecaApp.class);
        List<String> expectedMessage = new ArrayList<>(Collections.singletonList("Please select a valid option!"));

        List<String> actualMessage = menu.enterOption(bibliotecaApp, -1);

        assertEquals(expectedMessage, actualMessage);
    }
}