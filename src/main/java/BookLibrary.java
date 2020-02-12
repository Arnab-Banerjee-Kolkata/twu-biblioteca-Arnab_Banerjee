import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookLibrary {
    private List<Book> books;
    private List<Book> checkOutBooks;

    BookLibrary() {
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

    public String checkOutBook(Book book) {
        String message;

        if (books.contains(book)) {
            message = "Thank you! Enjoy the book";
            checkOutBooks.add(book);
            books.remove(book);
        } else
            message = "Sorry, that book is not available";
        return message;
    }

    public String returnBook(Book book) {
        String message;
        if (checkOutBooks.contains(book)) {
            checkOutBooks.remove(book);
            books.add(book);
            message = "Thank you for returning the book";
        } else {
            message = "That is not a valid book to return.";
        }

        return message;
    }

}
