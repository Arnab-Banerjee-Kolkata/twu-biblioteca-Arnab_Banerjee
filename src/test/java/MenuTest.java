import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MenuTest {
    Menu menu;
    Library library;
    BibliotecaApp bibliotecaApp;

    @BeforeEach
    void setUp() {
        menu = Menu.getInstance();
        library = mock(Library.class);
        bibliotecaApp = mock(BibliotecaApp.class);
    }

    @Test
    void shouldShowMenuOptions() {
        List<String> expectedMenuOptions = new ArrayList<>(Arrays.asList(
                "1. Show Available Books",
                "2. Exit",
                "3. Checkout",
                "4. Return"
        ));

        List<String> actualMenuOptions = menu.getOptions();

        assertEquals(expectedMenuOptions, actualMenuOptions);
    }

    @Test
    void shouldShowBookListIfOneIsEntered() throws IOException {
        menu.enterOption(bibliotecaApp, library, 1);

        verify(library, times(1)).showBooks();
    }

    @Test
    void shouldShowMessageWhenInvalidOptionIsEntered() throws IOException {
        String expectedMessage = "Please select a valid option!";

        String actualMessage = menu.enterOption(bibliotecaApp, library, -1);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldCallExitFunctionalityOfBibliotecaAppWhenExitOptionIsEntered() throws IOException {
        menu.enterOption(bibliotecaApp, library, 2);

        verify(bibliotecaApp, times(1)).exit();
    }

    @Test
    void shouldCallCheckOutFunctionalityOfBibliotecaAppOnEnteringCheckOutOption() throws IOException {
        menu.enterOption(bibliotecaApp, library, 3);

        verify(library, times(1)).checkOutBook();
    }

    @Test
    void shouldCallReturnBookFunctionOfBibliotecaAppOnReturningBook() throws IOException {
        menu.enterOption(bibliotecaApp, library, 4);

        verify(library, times(1)).returnBook();
    }
}