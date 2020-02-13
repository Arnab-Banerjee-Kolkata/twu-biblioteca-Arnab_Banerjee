public class ShowBooks implements MenuOption {
    private BookLibrary bookLibrary;

    public ShowBooks(BookLibrary bookLibrary) {
        this.bookLibrary = bookLibrary;
    }

    @Override
    public String execute() {
        return bookLibrary.showItems().toString();
    }
}
