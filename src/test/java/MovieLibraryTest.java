import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieLibraryTest {
    MovieLibrary movieLibrary;

    @BeforeEach
    void setup() {
        movieLibrary = new MovieLibrary();
    }

    @Test
    void shouldShowAvailableMovies() {
        Movie movie1 = new Movie("Movie_1", 1998, "Director_1", 9);
        Movie movie2 = new Movie("Movie_2", 1987, "Director_2", 8.5);
        List<String> expectedMovies = new ArrayList<>(Arrays.asList(
                movie1.getDetails(), movie2.getDetails()
        ));

        List<String> actualMovies = movieLibrary.showItems();

        assertEquals(expectedMovies, actualMovies);
    }

    @Test
    void shouldLetUserCheckoutABook() {
        Movie movie1 = new Movie("Movie_1", 1998, "Director_1", 9);
        List<String> expectedMovies = new ArrayList<>(Collections.singletonList(movie1.getDetails()));
        Movie movie2 = new Movie("Movie_2", 1987, "Director_2", 8.5);

        movieLibrary.checkOutItem(movie2);
        List<String> actualMovies = movieLibrary.showItems();

        assertEquals(expectedMovies, actualMovies);
    }
}