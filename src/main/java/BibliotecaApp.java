import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class BibliotecaApp {

    Menu menu;
    PrintStream outputStream;
    private Library library;

    public BibliotecaApp(PrintStream outputStream) {
        menu = Menu.getInstance();
        this.outputStream = outputStream;
        library = new Library(outputStream);
    }


    public String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public void exit() {
        System.exit(0);
    }

    public void startApp() throws IOException {
        showWelcomeMessage();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            outputStream.println("Enter your choice");
            outputStream.println(menu.getOptions());
            int choice = Integer.parseInt(bufferedReader.readLine());
            outputStream.println(menu.enterOption(this, library, choice));
        }

    }
}
