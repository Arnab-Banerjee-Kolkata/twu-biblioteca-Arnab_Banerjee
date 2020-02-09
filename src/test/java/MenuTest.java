import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MenuTest {
    Menu menu;

    @BeforeEach
    void setUp() {
        menu = Menu.getInstance();
    }

    @Test
    void shouldShowMenuOptions() {
        List<String> expectedMenuOptions = new ArrayList<>(Collections.singletonList(
                "1. Show Available Books"
        ));

        List<String> actualMenuOptions = menu.getOptions();

        assertEquals(expectedMenuOptions, actualMenuOptions);
    }

    @Test
    void shouldShowBookListIfOneIsEntered() {
        BibliotecaApp bibliotecaApp = mock(BibliotecaApp.class);

        menu.enterOption(bibliotecaApp, 1);

        verify(bibliotecaApp, times(1)).showBooks();
    }

    @Test
    void shouldShowMessageWhenInvalidOptionIsEntered() {
        BibliotecaApp bibliotecaApp = mock(BibliotecaApp.class);
        String expectedMessage = "Please select a valid option!";

        String actualMessage = menu.enterOption(bibliotecaApp, -1);

        assertEquals(expectedMessage, actualMessage);
    }
}