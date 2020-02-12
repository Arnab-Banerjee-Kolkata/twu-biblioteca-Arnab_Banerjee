import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookLibrary implements Library {
    private List<Item> books;
    private List<Item> checkOutBooks;

    BookLibrary() {
        checkOutBooks = new ArrayList<>();
        this.books = new ArrayList<>(Arrays.asList(
                new Book("Book_Name_1", "Author_Name_1", 1998),
                new Book("Book_Name_2", "Author_Name_2", 1987)
        ));
    }

    public List<String> showItems() {
        List<String> bookDetails = new ArrayList<>();
        for (Item book : books) {
            bookDetails.add(book.getDetails());
        }
        return bookDetails;
    }

    @Override
    public String checkOutItem(Item book) {
        String message;

        if (books.contains(book)) {
            message = "Thank you! Enjoy the book";
            checkOutBooks.add(book);
            books.remove(book);
        } else
            message = "Sorry, that book is not available";
        return message;
    }

    public String returnItem(Item book) {
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
