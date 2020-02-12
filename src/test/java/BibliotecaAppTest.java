import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BibliotecaAppTest {
    BibliotecaApp bibliotecaApp;

    @BeforeEach
    void setup() {
        bibliotecaApp = new BibliotecaApp(new Console(System.out));
    }

    @Test
    void shouldShowWelcomeMessageWhenAppIsStarted() {
        String welcomeMessage = bibliotecaApp.showWelcomeMessage();

        assertEquals("Welcome to Biblioteca." +
                " Your one-stop-shop for great book titles in Bangalore!", welcomeMessage);
    }

    @Test
    void shouldShowAvailableMovies() {
        Movie movie1 = new Movie("Movie_1", 1998, "Director_1", 9);
        Movie movie2 = new Movie("Movie_2", 1987, "Director_2", 8.5);
        List<String> expectedMovies = new ArrayList<>(Arrays.asList(
                movie1.getDetails(), movie2.getDetails()
        ));

        List<String> actualMovies = bibliotecaApp.showMovies();

        assertEquals(expectedMovies, actualMovies);
    }
}