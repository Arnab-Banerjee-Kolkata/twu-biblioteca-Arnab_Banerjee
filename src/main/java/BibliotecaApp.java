import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private List<Book> books;
    private List<Book> checkOutBooks;
    Menu menu;
    PrintStream outputStream;

    public BibliotecaApp(PrintStream outputStream) {
        this.checkOutBooks = new ArrayList<>();
        this.books = new ArrayList<>(Arrays.asList(
                new Book("Book_Name_1", "Author_Name_1", 1998),
                new Book("Book_Name_2", "Author_Name_2", 1987)
        ));
        menu = Menu.getInstance();
        this.outputStream = outputStream;
    }


    public String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public List<String> showBooks() {
        List<String> bookTitles = new ArrayList<>();
        for (Book book : books) {
            bookTitles.add(book.getDetails());
        }
        return bookTitles;
    }

    public void exit() {
        System.exit(0);
    }

    public String checkOutBook() throws IOException {
        String message;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        outputStream.println("Enter title");
        String bookTitle = bufferedReader.readLine();
        outputStream.println("Enter author name");
        String authorName = bufferedReader.readLine();
        outputStream.println("Enter year of publishing");
        try {
            int yearOfPublishing = Integer.parseInt(bufferedReader.readLine());
            Book book = new Book(bookTitle, authorName, yearOfPublishing);
            if (books.contains(book)) {
                message = "Thank you! Enjoy the book";
                checkOutBooks.add(book);
            } else
                message = "Sorry, that book is not available";
            books.remove(book);
        } catch (NumberFormatException e) {
            message = "Invalid Input";
        }
        return message;
    }

    public String returnBook() throws IOException {
        String message;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        outputStream.println("Enter title");
        String bookTitle = bufferedReader.readLine();
        outputStream.println("Enter author name");
        String authorName = bufferedReader.readLine();
        outputStream.println("Enter year of publishing");
        try {
            int yearOfPublishing = Integer.parseInt(bufferedReader.readLine());
            Book book = new Book(bookTitle, authorName, yearOfPublishing);
            if (checkOutBooks.contains(book)) {
                checkOutBooks.remove(book);
                books.add(book);
                message = "Thank you for returning the book";
            } else
                message = "That is not a valid book to return.";
        } catch (NumberFormatException e) {
            message = "Invalid Input";
        }
        return message;
    }

    public void startApp() throws IOException {
        showWelcomeMessage();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            outputStream.println("Enter your choice");
            outputStream.println(menu.getOptions());
            int choice = Integer.parseInt(bufferedReader.readLine());
            outputStream.println(menu.enterOption(this, choice));
        }

    }
}
