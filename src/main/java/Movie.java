import java.text.DecimalFormat;

public class Movie {
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
}
