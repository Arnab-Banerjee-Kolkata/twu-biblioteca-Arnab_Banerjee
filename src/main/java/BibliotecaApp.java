import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private List<Book> books;
    private List<Book> checkOutBooks;
    Menu menu;
    PrintStream outputStream;

    public BibliotecaApp(PrintStream outputStream) {
        this.checkOutBooks = new ArrayList<>();
        this.books = new ArrayList<>(Arrays.asList(
                new Book("Book_Name_1", "Author_Name_1", 1998),
                new Book("Book_Name_2", "Author_Name_2", 1987)
        ));
        menu = Menu.getInstance();
        this.outputStream = outputStream;
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
            outputStream.println(menu.enterOption(this, choice));
        }

    }
}
