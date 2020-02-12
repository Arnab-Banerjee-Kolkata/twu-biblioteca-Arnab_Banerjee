import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {
    @Test
    void shouldShowDetailsOfAMovie() {
        Movie movie = new Movie("Movie_1", 1974, "Director_1", 9);
        String expectedDetails = "Movie_1 1974 Director_1 9";

        String actualDetails = movie.getDetails();

        assertEquals(expectedDetails, actualDetails);
    }
}