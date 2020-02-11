import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Book> checkOutBooks;
    private PrintStream outputStream;

    Library(PrintStream outputStream) {
        this.outputStream = outputStream;
        checkOutBooks = new ArrayList<>();
        this.books = new ArrayList<>(Arrays.asList(
                new Book("Book_Name_1", "Author_Name_1", 1998),
                new Book("Book_Name_2", "Author_Name_2", 1987)
        ));
    }

    public List<String> showBooks() {
        List<String> bookDetails = new ArrayList<>();
        for (Book book : books) {
            bookDetails.add(book.getDetails());
        }
        return bookDetails;
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
}