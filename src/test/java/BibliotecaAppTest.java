import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Book book1 = new Book("Book_Name_1", null, 0);
        Book book2 = new Book("Book_Name_2", null, 0);
        List<String> expectedBooks = new ArrayList<>(Arrays.asList(book1.getTitle(), book2.getTitle()));

        String welcomeMessage = bibliotecaApp.showWelcomeMessage();
        List<String> actualBooks = bibliotecaApp.showBooks();

        assertEquals("Welcome to Biblioteca." +
                " Your one-stop-shop for great book titles in Bangalore!", welcomeMessage);
        assertEquals(expectedBooks, actualBooks);

    }

    @Test
    void shouldShowListOfBooksWithTitleAuthorAndPublishedYear() {
        Book book1 = new Book("Book_Name_1", "Author_Name_1", 1998);
        Book book2 = new Book("Book_Name_2", "Author_Name_2", 1987);
        String expectedDetails = "Book_Name_2 Author_Name_2 1987";
        List<String> expectedBooks = new ArrayList<>(Arrays.asList(book1.getTitle(), book2.getTitle()));

        List<String> actualBooks = bibliotecaApp.showBooks();
        String actualDetails = book2.getDetails();

        assertEquals(expectedBooks, actualBooks);
        assertEquals(expectedDetails, actualDetails);
    }

    @Test
    void shouldShowMenuOptionsAfterWelcomeMessage() {
        List<String> expectedMenuOptions = new ArrayList<>(Arrays.asList(
                "1. Show Available Books",
                "2. Exit"
        ));

        String welcomeMessage = bibliotecaApp.showWelcomeMessage();
        List<String> actualMenuOptions = bibliotecaApp.showMenu();

        assertEquals("Welcome to Biblioteca." +
                " Your one-stop-shop for great book titles in Bangalore!", welcomeMessage);

        assertEquals(expectedMenuOptions, actualMenuOptions);

    }
}