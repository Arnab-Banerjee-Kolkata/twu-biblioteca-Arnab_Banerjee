import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private List<String> menuOptions;
    StringBuilder message;

    Menu() {
        menuOptions = new ArrayList<>(Arrays.asList(
                "1. Show Available Books",
                "2. Exit",
                "3. Checkout",
                "4. Return"
        ));
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
                message.append(library.checkOutBook());
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
