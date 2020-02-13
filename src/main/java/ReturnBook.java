public class ReturnBook implements MenuOption {
    private BookLibrary bookLibrary;
    private Book book;

    public ReturnBook(BookLibrary bookLibrary, Book book) {
        this.bookLibrary = bookLibrary;
        this.book = book;
    }

    @Override
    public String execute() {
        return bookLibrary.returnItem(book);
    }
}
