import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BibliotecaAppTest {
    BibliotecaApp bibliotecaApp;

    @BeforeEach
    void setup() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bibliotecaApp = new BibliotecaApp(bufferedReader, System.out);
    }

    @Test
    void shouldShowWelcomeMessageWhenAppIsStarted() {
        String welcomeMessage = bibliotecaApp.showWelcomeMessage();

        assertEquals("Welcome to Biblioteca." +
                " Your one-stop-shop for great book titles in Bangalore!", welcomeMessage);
    }

    @Test
    void shouldShowAListOfAvailableBooksAfterDisplayingWelcomeMessage() {
        Book book1 = new Book("Book_Name_1", "Author_Name_1", 1998);
        Book book2 = new Book("Book_Name_2", "Author_Name_2", 1987);
        List<String> expectedBooks = new ArrayList<>(Arrays.asList(book1.getDetails(), book2.getDetails()));

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
        List<String> expectedBooks = new ArrayList<>(Arrays.asList(book1.getDetails(), book2.getDetails()));

        List<String> actualBooks = bibliotecaApp.showBooks();
        String actualDetails = book2.getDetails();

        assertEquals(expectedBooks, actualBooks);
        assertEquals(expectedDetails, actualDetails);
    }

    @Test
    void shouldLetUserCheckoutABook() throws IOException {
        Book book1 = new Book("Book_Name_1", "Author_Name_1", 1998);
        List<String> expectedBooks = new ArrayList<>(Collections.singletonList(book1.getDetails()));
        String simulatedInput = "Book_Name_2\nAuthor_Name_2\n1987";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        bibliotecaApp.checkOutBook();
        List<String> actualBooks = bibliotecaApp.showBooks();

        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    void shouldNotifyUserWhenABookIsSuccessfullyCheckedOut() throws IOException {
        String simulatedInput = "Book_Name_2\nAuthor_Name_2\n1987";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        String expectedMessage = "Thank you! Enjoy the book";

        String actualMessage = bibliotecaApp.checkOutBook();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldNotifyUserWhenABookCannotBeCheckedOut() throws IOException {
        String simulatedInput = "Book_Name_3\nAuthor_Name_3\n1991";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        String expectedMessage = "Sorry, that book is not available";

        String actualMessage = bibliotecaApp.checkOutBook();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldAllowUserToReturnABook() throws IOException {
        Book book1 = new Book("Book_Name_1", "Author_Name_1", 1998);
        Book book2 = new Book("Book_Name_2", "Author_Name_2", 1987);
        List<String> expectedBooks = new ArrayList<>(Arrays.asList(book1.getDetails(), book2.getDetails()));
        String simulatedInput = "Book_Name_2\nAuthor_Name_2\n1987";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        bibliotecaApp.checkOutBook();
        simulatedInput = "Book_Name_2\nAuthor_Name_2\n1987";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        bibliotecaApp.returnBook();
        List<String> actualBooks = bibliotecaApp.showBooks();

        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    void shouldNotifyUserWhenABookIsSuccessfullyReturned() throws IOException {
        String simulatedInput = "Book_Name_2\nAuthor_Name_2\n1987";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        String expectedMessage = "Thank you for returning the book";

        bibliotecaApp.checkOutBook();
        simulatedInput = "Book_Name_2\nAuthor_Name_2\n1987";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        String actualMessage = bibliotecaApp.returnBook();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldNotifyUserIfBookIsNotSuccessfullyReturned() throws IOException {
        String expectedMessage = "That is not a valid book to return.";

        String simulatedInput = "Book_Name_3\nAuthor_Name_3\n1991";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        String actualMessage = bibliotecaApp.returnBook();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldDisplayMessageOnEnteringInvalidInputDuringCheckout() throws IOException {
        String simulatedInput = "Book_Name_2\nAuthor_Name_2\na";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        String expectedMessage = "Invalid Input";

        String actualMessage = bibliotecaApp.checkOutBook();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldDisplayMessageOnEnteringInvalidInputDuringReturningBook() throws IOException {
        String simulatedInput = "Book_Name_2\nAuthor_Name_2\naa";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        String expectedMessage = "Invalid Input";

        String actualMessage = bibliotecaApp.returnBook();

        assertEquals(expectedMessage, actualMessage);
    }
}