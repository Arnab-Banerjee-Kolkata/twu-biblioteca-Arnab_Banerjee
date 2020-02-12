import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookLibraryTest {
    BookLibrary bookLibrary;

    @BeforeEach
    void setup() {
        bookLibrary = new BookLibrary();
    }

    @Test
    void shouldShowAListOfAvailableBooks() {
        Book book1 = new Book("Book_Name_1", "Author_Name_1", 1998);
        Book book2 = new Book("Book_Name_2", "Author_Name_2", 1987);
        List<String> expectedBooks = new ArrayList<>(Arrays.asList(book1.getDetails(), book2.getDetails()));

        List<String> actualBooks = bookLibrary.showBooks();

        assertEquals(expectedBooks, actualBooks);

    }

    @Test
    void shouldLetUserCheckoutABook() {
        Book book1 = new Book("Book_Name_1", "Author_Name_1", 1998);
        List<String> expectedBooks = new ArrayList<>(Collections.singletonList(book1.getDetails()));
        Book book2 = new Book("Book_Name_2", "Author_Name_2", 1987);

        bookLibrary.checkOutBook(book2);
        List<String> actualBooks = bookLibrary.showBooks();

        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    void shouldNotifyUserWhenABookIsSuccessfullyCheckedOut() {
        Book book = new Book("Book_Name_2", "Author_Name_2", 1987);
        String expectedMessage = "Thank you! Enjoy the book";

        String actualMessage = bookLibrary.checkOutBook(book);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldNotifyUserWhenABookCannotBeCheckedOut() {
        Book book = new Book("Book_Name_3", "Author_Name_3", 1999);
        String expectedMessage = "Sorry, that book is not available";

        String actualMessage = bookLibrary.checkOutBook(book);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldAllowUserToReturnABook() {
        Book book1 = new Book("Book_Name_1", "Author_Name_1", 1998);
        Book book2 = new Book("Book_Name_2", "Author_Name_2", 1987);
        List<String> expectedBooks = new ArrayList<>(Arrays.asList(book1.getDetails(), book2.getDetails()));

        bookLibrary.checkOutBook(book2);
        bookLibrary.returnBook(book2);
        List<String> actualBooks = bookLibrary.showBooks();

        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    void shouldNotifyUserWhenABookIsSuccessfullyReturned() {
        Book book = new Book("Book_Name_2", "Author_Name_2", 1987);
        String expectedMessage = "Thank you for returning the book";

        bookLibrary.checkOutBook(book);
        String actualMessage = bookLibrary.returnBook(book);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldNotifyUserIfBookIsNotSuccessfullyReturned() {
        String expectedMessage = "That is not a valid book to return.";
        Book book = new Book("Book_Name_3", "Author_Name_3", 1999);

        String actualMessage = bookLibrary.returnBook(book);

        assertEquals(expectedMessage, actualMessage);
    }
}