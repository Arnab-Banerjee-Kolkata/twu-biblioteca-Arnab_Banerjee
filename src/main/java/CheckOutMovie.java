public class CheckOutMovie implements MenuOption {
    private final MovieLibrary movieLibrary;
    private final Movie movie;

    public CheckOutMovie(MovieLibrary movieLibrary, Movie movie) {
        this.movieLibrary = movieLibrary;
        this.movie = movie;
    }

    @Override
    public String execute() {
        movieLibrary.checkOutItem(movie);
        return null;
    }
}
