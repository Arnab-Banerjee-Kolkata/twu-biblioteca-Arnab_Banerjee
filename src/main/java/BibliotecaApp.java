import java.io.IOException;

public class BibliotecaApp {

    private boolean isOpen;
    private Menu menu;
    private Console console;

    public BibliotecaApp(Console console) {
        this.console = console;
        BookLibrary bookLibrary = new BookLibrary();
        isOpen = true;
        MovieLibrary movieLibrary = new MovieLibrary();
        menu = new Menu(console, this, bookLibrary, movieLibrary);
    }


    public String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public void exit() {
        isOpen = false;
    }

    public void startApp() throws IOException {
        showWelcomeMessage();
        do {
            console.println("Enter your choice");
            console.println(menu.getOptions().toString());
            int choice = Integer.parseInt(console.readLine());
            console.println(menu.enterOption(choice));
        } while (isOpen);

    }
}
