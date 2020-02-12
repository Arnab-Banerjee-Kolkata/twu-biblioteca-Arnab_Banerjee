import java.io.IOException;

public class BibliotecaApp {

    private boolean isOpen;
    private Menu menu;
    private Library library;
    private Console console;

    public BibliotecaApp(Console console) {
        this.console = console;
        menu = new Menu(console);
        library = new Library();
        isOpen = true;
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
            console.println(menu.enterOption(this, library, choice));
        } while (isOpen);

    }
}
