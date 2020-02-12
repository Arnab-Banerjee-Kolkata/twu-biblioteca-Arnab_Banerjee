import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaApp {

    private boolean isOpen;
    Menu menu;
    private Library library;
    private Console console;

    public BibliotecaApp(Console console) {
        this.console = console;
        menu = new Menu();
        library = new Library(console);
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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        do {
            console.println("Enter your choice");
            console.println(menu.getOptions().toString());
            int choice = Integer.parseInt(bufferedReader.readLine());
            console.println(menu.enterOption(this, library, choice));
        } while (isOpen);

    }
}
