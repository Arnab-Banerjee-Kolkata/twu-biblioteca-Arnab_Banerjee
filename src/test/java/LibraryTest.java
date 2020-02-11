import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {
    Library library;

    @BeforeEach
    void setup() {
        library = new Library(System.out);
    }

    @Test
    void shouldShowAListOfAvailableBooks() {
        Book book1 = new Book("Book_Name_1", "Author_Name_1", 1998);
        Book book2 = new Book("Book_Name_2", "Author_Name_2", 1987);
        List<String> expectedBooks = new ArrayList<>(Arrays.asList(book1.getDetails(), book2.getDetails()));

        List<String> actualBooks = library.showBooks();

        assertEquals(expectedBooks, actualBooks);

    }

    @Test
    void shouldLetUserCheckoutABook() throws IOException {
        Book book1 = new Book("Book_Name_1", "Author_Name_1", 1998);
        List<String> expectedBooks = new ArrayList<>(Collections.singletonList(book1.getDetails()));
        String simulatedInput = "Book_Name_2\nAuthor_Name_2\n1987";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        library.checkOutBook();
        List<String> actualBooks = library.showBooks();

        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    void shouldNotifyUserWhenABookIsSuccessfullyCheckedOut() throws IOException {
        String simulatedInput = "Book_Name_2\nAuthor_Name_2\n1987";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        String expectedMessage = "Thank you! Enjoy the book";

        String actualMessage = library.checkOutBook();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldNotifyUserWhenABookCannotBeCheckedOut() throws IOException {
        String simulatedInput = "Book_Name_3\nAuthor_Name_3\n1991";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        String expectedMessage = "Sorry, that book is not available";

        String actualMessage = library.checkOutBook();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldAllowUserToReturnABook() throws IOException {
        Book book1 = new Book("Book_Name_1", "Author_Name_1", 1998);
        Book book2 = new Book("Book_Name_2", "Author_Name_2", 1987);
        List<String> expectedBooks = new ArrayList<>(Arrays.asList(book1.getDetails(), book2.getDetails()));
        String simulatedInput = "Book_Name_2\nAuthor_Name_2\n1987";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        library.checkOutBook();
        simulatedInput = "Book_Name_2\nAuthor_Name_2\n1987";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        library.returnBook();
        List<String> actualBooks = library.showBooks();

        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    void shouldNotifyUserWhenABookIsSuccessfullyReturned() throws IOException {
        String simulatedInput = "Book_Name_2\nAuthor_Name_2\n1987";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        String expectedMessage = "Thank you for returning the book";

        library.checkOutBook();
        simulatedInput = "Book_Name_2\nAuthor_Name_2\n1987";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        String actualMessage = library.returnBook();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldNotifyUserIfBookIsNotSuccessfullyReturned() throws IOException {
        String expectedMessage = "That is not a valid book to return.";

        String simulatedInput = "Book_Name_3\nAuthor_Name_3\n1991";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        String actualMessage = library.returnBook();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldDisplayMessageOnEnteringInvalidInputDuringCheckout() throws IOException {
        String simulatedInput = "Book_Name_2\nAuthor_Name_2\na";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        String expectedMessage = "Invalid Input";

        String actualMessage = library.checkOutBook();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldDisplayMessageOnEnteringInvalidInputDuringReturningBook() throws IOException {
        String simulatedInput = "Book_Name_2\nAuthor_Name_2\naa";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        String expectedMessage = "Invalid Input";

        String actualMessage = library.returnBook();

        assertEquals(expectedMessage, actualMessage);
    }
}