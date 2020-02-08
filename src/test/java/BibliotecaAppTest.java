import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BibliotecaAppTest {

    @Test
    void shouldShowWelcomeMessageWhenAppIsStarted() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        String welcomeMessage = bibliotecaApp.showWelcomeMessage();

        assertEquals("Welcome to Biblioteca." +
                " Your one-stop-shop for great book titles in Bangalore!", welcomeMessage);
    }

    @Test
    void shouldShowAListOfAvailableBooksAfterDisplayingWelcomeMessage() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        List<String> expectedBooks = new ArrayList<>(Arrays.asList(
                "Book_Name_1",
                "Book_Name_2"
        ));

        String welcomeMessage = bibliotecaApp.showWelcomeMessage();
        List<String> actualBooks = bibliotecaApp.showBooks();

        assertEquals("Welcome to Biblioteca." +
                " Your one-stop-shop for great book titles in Bangalore!", welcomeMessage);
        assertEquals(expectedBooks, actualBooks);

    }
}