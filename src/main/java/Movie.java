import java.text.DecimalFormat;
import java.util.Objects;

public class Movie implements Item {
    private final String name;
    private final int yearOfRelease;
    private final String directorName;
    private final double rating;

    public Movie(String name, int yearOfRelease, String directorName, double rating) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.directorName = directorName;
        this.rating = rating;
    }

    public String getDetails() {
        DecimalFormat decimalFormat = new DecimalFormat("0.#");
        return name + " " + yearOfRelease + " " + directorName + " " + decimalFormat.format(rating);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return yearOfRelease == movie.yearOfRelease &&
                rating == movie.rating &&
                name.equals(movie.name) &&
                directorName.equals(movie.directorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearOfRelease, directorName, rating);
    }
}
