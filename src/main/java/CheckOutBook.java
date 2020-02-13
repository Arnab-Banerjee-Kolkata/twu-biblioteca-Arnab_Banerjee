public class CheckOutBook implements MenuOption {
    private BookLibrary bookLibrary;
    private Book book;

    public CheckOutBook(BookLibrary bookLibrary, Book book) {

        this.bookLibrary = bookLibrary;
        this.book = book;
    }

    @Override
    public String execute() {
        return bookLibrary.checkOutItem(book);
    }
}
