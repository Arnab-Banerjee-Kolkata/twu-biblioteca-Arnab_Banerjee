import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        String expectedBooks = book1.getTitle() + "\n" + book2.getTitle();

        String welcomeMessage = bibliotecaApp.showWelcomeMessage();
        String actualBooks = bibliotecaApp.showBooks();

        assertEquals("Welcome to Biblioteca." +
                " Your one-stop-shop for great book titles in Bangalore!", welcomeMessage);
        assertEquals(expectedBooks, actualBooks);

    }

    @Test
    void shouldShowListOfBooksWithTitleAuthorAndPublishedYear() {
        Book book1 = new Book("Book_Name_1", "Author_Name_1", 1998);
        Book book2 = new Book("Book_Name_2", "Author_Name_2", 1987);
        String expectedBooks = book1.getTitle() + " " + book1.getAuthor() + " " + book1.getYearOfPublishing() + "\n" +
                book2.getTitle() + " " + book2.getAuthor() + " " + book2.getYearOfPublishing();

        String actualBooks = bibliotecaApp.showBooks();

        assertEquals(expectedBooks, actualBooks);
    }
}