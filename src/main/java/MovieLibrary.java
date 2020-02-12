import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieLibrary {
    private List<Movie> movies;

    MovieLibrary() {
        this.movies = new ArrayList<>(Arrays.asList(
                new Movie("Movie_1", 1998, "Director_1", 9),
                new Movie("Movie_2", 1987, "Director_2", 8.5)
        ));
    }

    public List<String> showMovies() {
        List<String> movieDetails = new ArrayList<>();
        for (Movie movie : movies) {
            movieDetails.add(movie.getDetails());
        }
        return movieDetails;
    }
}
