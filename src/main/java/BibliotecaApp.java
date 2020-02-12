import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class BibliotecaApp {

    private boolean isOpen;
    Menu menu;
    PrintStream outputStream;
    private Library library;

    public BibliotecaApp(PrintStream outputStream) {
        menu = new Menu();
        this.outputStream = outputStream;
        library = new Library(outputStream);
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
            outputStream.println("Enter your choice");
            outputStream.println(menu.getOptions());
            int choice = Integer.parseInt(bufferedReader.readLine());
            outputStream.println(menu.enterOption(this, library, choice));
        } while (isOpen);

    }
}
