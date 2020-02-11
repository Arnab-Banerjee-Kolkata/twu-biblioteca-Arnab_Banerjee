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
}