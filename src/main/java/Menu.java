import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private List<String> menuOptions;
    private StringBuilder message;
    private Console console;

    Menu(Console console) {
        menuOptions = new ArrayList<>(Arrays.asList(
                "1. Show Available Books",
                "2. Exit",
                "3. Checkout",
                "4. Return"
        ));
        this.console = console;
    }

    private Book readBook() throws IOException {
        console.println("Enter book title:");
        String title = console.readLine();
        console.println("Enter author name:");
        String authorName = console.readLine();
        console.println("Enter year of publishing:");
        int yearOfPublishing = Integer.parseInt(console.readLine());
        return new Book(title, authorName, yearOfPublishing);
    }


    public List<String> getOptions() {
        return this.menuOptions;
    }

    public String enterOption(BibliotecaApp bibliotecaApp, Library library, int optionNumber) throws IOException {
        message = new StringBuilder();
        switch (optionNumber) {
            case 1:
                message = new StringBuilder(library.showBooks().toString());
                formMessage();
                break;
            case 2:
                bibliotecaApp.exit();
                break;
            case 3:
                message.append(library.checkOutBook(null));
                formMessage();
                break;
            case 4:
                message.append(library.returnBook());
                formMessage();
                break;
            default:
                message = new StringBuilder("Please select a valid option!");
        }
        return message.toString().trim();
    }

    private void formMessage() {
        String[] listOfBooks;
        listOfBooks = message.toString().split(",");
        message = new StringBuilder();
        for (String item : listOfBooks)
            message.append(item).append("\n");
    }
}
