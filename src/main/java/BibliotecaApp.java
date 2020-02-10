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
        this.checkOutBooks = new ArrayList<>();
        this.books = new ArrayList<>(Arrays.asList(
                new Book("Book_Name_1", "Author_Name_1", 1998),
                new Book("Book_Name_2", "Author_Name_2", 1987)
        ));
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

    public void exit() {
        System.exit(0);
    }

    public String checkOutBook() throws IOException {
        String message;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter title");
        String bookTitle = bufferedReader.readLine();
        System.out.println("Enter author name");
        String authorName = bufferedReader.readLine();
        System.out.println("Enter year of publishing");
        int yearOfPublishing = Integer.parseInt(bufferedReader.readLine());
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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter title");
        String bookTitle = bufferedReader.readLine();
        System.out.println("Enter author name");
        String authorName = bufferedReader.readLine();
        System.out.println("Enter year of publishing");
        int yearOfPublishing = Integer.parseInt(bufferedReader.readLine());
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
