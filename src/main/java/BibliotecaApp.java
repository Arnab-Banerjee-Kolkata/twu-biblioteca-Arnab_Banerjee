import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    public List<Book> showBooks() {
        return this.books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BibliotecaApp that = (BibliotecaApp) o;
        boolean isSame = true;
        for (int a = 0; a < books.size(); a++) {
            if (!books.get(a).equals(that.books.get(a))) {
                isSame = false;
                break;
            }
        }
        return isSame;
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }
}
