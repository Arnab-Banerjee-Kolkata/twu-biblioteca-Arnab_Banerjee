import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookTest {
    @Test
    void shouldReadTheBookTitleAuthorAndPublishingYear() {
        Book book = new Book("Book_Name", "Author_Name", 1998);

        String title = book.getTitle();
        String author = book.getAuthor();
        int yearOfPublishing = book.getYearOfPublishing();

        assertEquals("Book_Name", title);
        assertEquals("Author_Name", author);
        assertEquals(1998, yearOfPublishing);
    }

    @Test
    void shouldReturnTrueIfTwoBooksWithSameDetailsAreCompared() {
        Book book1 = new Book("Book_Name_1", "Author_Name_1", 1998);
        Book book2 = new Book("Book_Name_1", "Author_Name_1", 1998);

        boolean isSame = book1.equals(book2);

        assertTrue(isSame);
    }

    @Test
    void shouldPassIfBookDetailsCanBeRead() {
        Book book = new Book("Book_Name", "Author_Name", 1990);
        String expectedDetails = "Book_Name Author_Name 1990";

        String actualDetails = book.getDetails();

        assertEquals(expectedDetails, actualDetails);
    }
}