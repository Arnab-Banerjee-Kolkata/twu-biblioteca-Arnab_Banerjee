import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    private List<Book> books;

    Library() {
        this.books = new ArrayList<>(Arrays.asList(
                new Book("Book_Name_1", "Author_Name_1", 1998),
                new Book("Book_Name_2", "Author_Name_2", 1987)
        ));
    }

    public List<String> showBooks() {
        List<String> bookTitles = new ArrayList<>();
        for (Book book : books) {
            bookTitles.add(book.getDetails());
        }
        return bookTitles;
    }
}
