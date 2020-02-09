import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private List<Book> books;
    private List<Book> checkOutBooks;

    public BibliotecaApp() {
        this.showWelcomeMessage();
        this.checkOutBooks = new ArrayList<>();
        this.books = new ArrayList<>(Arrays.asList(
                new Book("Book_Name_1", "Author_Name_1", 1998),
                new Book("Book_Name_2", "Author_Name_2", 1987)
        ));
        this.showMenu();
    }

    public String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public List<String> showBooks() {
        List<String> bookTitles = new ArrayList<>();
        for (Book book : books) {
            bookTitles.add(book.getTitle());
        }
        return bookTitles;
    }

    public List<String> showMenu() {
        return Menu.getInstance().getOptions();
    }

    public void exit() {
        System.exit(0);
    }

    public String checkOutBook() throws IOException {
        String message;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String bookTitle = in.readLine();
        String authorName = in.readLine();
        int yearOfPublishing = Integer.parseInt(in.readLine());
        Book book = new Book(bookTitle, authorName, yearOfPublishing);
        if (books.contains(book)) {
            message = "Thank you! Enjoy the book";
            checkOutBooks.add(book);
        } else
            message = "Sorry, that book is not available";
        books.remove(book);
        return message;
    }

    public String returnBook() throws IOException {
        String message;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String bookTitle = in.readLine();
        String authorName = in.readLine();
        int yearOfPublishing = Integer.parseInt(in.readLine());
        Book book = new Book(bookTitle, authorName, yearOfPublishing);
        if (checkOutBooks.contains(book)) {
            checkOutBooks.remove(book);
            books.add(book);
            message = "Thank you for returning the book";
        } else
            message = "That is not a valid book to return.";
        return message;
    }
}
