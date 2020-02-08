import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}