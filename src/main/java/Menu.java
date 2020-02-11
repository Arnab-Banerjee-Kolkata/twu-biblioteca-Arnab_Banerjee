import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private static Menu menu;
    private List<String> menuOptions;

    private Menu() {
    }

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
            menu.menuOptions = new ArrayList<>(Arrays.asList(
                    "1. Show Available Books",
                    "2. Exit",
                    "3. Checkout",
                    "4. Return"
            ));
        }
        return menu;
    }

    public List<String> getOptions() {
        return this.menuOptions;
    }

    public String enterOption(BibliotecaApp bibliotecaApp, Library library, int optionNumber) throws IOException {
        StringBuilder message = new StringBuilder();
        String[] listOfBooks;
        switch (optionNumber) {
            case 1:
                message = new StringBuilder(library.showBooks().toString());
                listOfBooks = message.toString().split(",");
                message = new StringBuilder();
                for (String item : listOfBooks)
                    message.append(item).append("\n");
                break;
            case 2:
                bibliotecaApp.exit();
                break;
            case 3:
                message.append(library.checkOutBook());
                listOfBooks = message.toString().split(",");
                message = new StringBuilder();
                for (String item : listOfBooks)
                    message.append(item).append("\n");
                break;
            case 4:
                message.append(library.returnBook());
                listOfBooks = message.toString().split(",");
                message = new StringBuilder();
                for (String item : listOfBooks)
                    message.append(item).append("\n");
                break;
            default:
                message = new StringBuilder("Please select a valid option!");
        }
        return message.toString().trim();
    }
}
