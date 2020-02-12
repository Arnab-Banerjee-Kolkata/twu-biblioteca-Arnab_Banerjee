import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private boolean isOpen;
    private Menu menu;
    private Library library;
    private Console console;
    private List<Movie> movies;

    public BibliotecaApp(Console console) {
        this.console = console;
        menu = new Menu();
        library = new Library(console);
        isOpen = true;
        this.movies = new ArrayList<>(Arrays.asList(
                new Movie("Movie_1", 1998, "Director_1", 9),
                new Movie("Movie_2", 1987, "Director_2", 8.5)
        ));
    }


    public String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public void exit() {
        isOpen = false;
    }

    public void startApp() throws IOException {
        showWelcomeMessage();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        do {
            console.println("Enter your choice");
            console.println(menu.getOptions().toString());
            int choice = Integer.parseInt(bufferedReader.readLine());
            console.println(menu.enterOption(this, library, choice));
        } while (isOpen);

    }

    public List<String> showMovies() {
        List<String> movieDetails = new ArrayList<>();
        for (Movie movie : movies) {
            movieDetails.add(movie.getDetails());
        }
        return movieDetails;
    }
}
