import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {
    Library library;

    @BeforeEach
    void setup() {
        library = new Library();
    }

    @Test
    void shouldShowAListOfAvailableBooks() {
        Book book1 = new Book("Book_Name_1", "Author_Name_1", 1998);
        Book book2 = new Book("Book_Name_2", "Author_Name_2", 1987);
        List<String> expectedBooks = new ArrayList<>(Arrays.asList(book1.getDetails(), book2.getDetails()));

        List<String> actualBooks = library.showBooks();

        assertEquals(expectedBooks, actualBooks);

    }
}