import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private List<Book> books;

    public BibliotecaApp() {
        this.showWelcomeMessage();
        this.books = new ArrayList<>(Arrays.asList(
                new Book("Book_Name_1", "Author_Name_1", 1998),
                new Book("Book_Name_2", "Author_Name_2", 1987)
        ));
        this.showBooks();
    }

    public String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String showBooks() {
        StringBuilder bookDetails = new StringBuilder();
        for (Book book : books) {
            bookDetails.append(book.getTitle()).append(" ").append(book.getAuthor()).append(" ").
                    append(book.getYearOfPublishing()).append("\n");
        }
        return bookDetails.toString().trim();
    }

}
