import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BibliotecaAppTest {
    BibliotecaApp bibliotecaApp;

    @BeforeEach
    void setup() {
        bibliotecaApp = new BibliotecaApp();
    }

    @Test
    void shouldShowWelcomeMessageWhenAppIsStarted() {
        String welcomeMessage = bibliotecaApp.showWelcomeMessage();

        assertEquals("Welcome to Biblioteca." +
                " Your one-stop-shop for great book titles in Bangalore!", welcomeMessage);
    }

    @Test
    void shouldShowAListOfAvailableBooksAfterDisplayingWelcomeMessage() {
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

    @Test
    void shouldShowListOfBooksWithTitleAuthorAndPublishedYear() {
        Book book1 = mock(Book.class);
    }
}