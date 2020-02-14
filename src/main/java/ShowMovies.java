public class ShowMovies implements MenuOption {
    private MovieLibrary movieLibrary;

    public ShowMovies(MovieLibrary movieLibrary) {
        this.movieLibrary = movieLibrary;
    }

    @Override
    public String execute() {
        return movieLibrary.showItems().toString();
    }
}
