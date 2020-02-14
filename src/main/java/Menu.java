import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private BibliotecaApp bibliotecaApp;
    private BookLibrary bookLibrary;
    private MovieLibrary movieLibrary;
    private List<String> menuOptions;
    private StringBuilder message;
    private Console console;

    Menu(Console console, BibliotecaApp bibliotecaApp, BookLibrary bookLibrary, MovieLibrary movieLibrary) {
        this.bibliotecaApp = bibliotecaApp;
        this.bookLibrary = bookLibrary;
        this.movieLibrary = movieLibrary;
        menuOptions = new ArrayList<>(Arrays.asList(
                "1. Show Available Books",
                "\n2. Exit",
                "\n3. Checkout Book",
                "\n4. Return Book",
                "\n5. Show Available Movies",
                "\n6. Checkout Movie"
        ));
        this.console = console;
    }

    public List<String> getOptions() {
        return this.menuOptions;
    }


    //TODO-Make one library
    //TODO-Make different classes after completing requirements
    public String enterOption(int optionNumber) throws IOException {
        message = new StringBuilder();
        switch (optionNumber) {
            case 1:
                message = new StringBuilder(new ShowBooks(bookLibrary).execute());
                formMessage();
                break;
            case 2:
                bibliotecaApp.exit();
                break;
            case 3:
                Book book = console.readBook();
                message.append(new CheckOutBook(bookLibrary, book).execute());
                formMessage();
                break;
            case 4:
                book = console.readBook();
                message.append(new ReturnBook(bookLibrary, book).execute());
                formMessage();
                break;
            case 5:
                message = new StringBuilder(new ShowMovies(movieLibrary).execute());
                formMessage();
                break;
            case 6:
                Movie movie = new Movie("Movie_2", 1987, "Director_2", 8.5);
                new CheckOutMovie(movieLibrary, movie).execute();
            default:
                message = new StringBuilder("Please select a valid option!");
        }
        return message.toString().trim();


    }

    private void formMessage() {
        String[] listOfItems;
        listOfItems = message.toString().split(",");
        message = new StringBuilder();
        for (String item : listOfItems)
            message.append(item).append("\n");
    }
}
