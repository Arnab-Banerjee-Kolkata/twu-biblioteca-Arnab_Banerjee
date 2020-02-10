import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public void getOptions(BibliotecaApp bibliotecaApp) throws IOException {
        System.out.println(this.menuOptions);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your choice:");
        int choice = (Integer.parseInt(bufferedReader.readLine()));
        enterOption(bibliotecaApp, choice);
    }

    public void enterOption(BibliotecaApp bibliotecaApp, int optionNumber) throws IOException {
        StringBuilder message = new StringBuilder();
        String[] listOfBooks;
        switch (optionNumber) {
            case 1:
                message = new StringBuilder(bibliotecaApp.showBooks().toString());
                listOfBooks = message.toString().split(",");
                message = new StringBuilder();
                for (String item : listOfBooks)
                    message.append(item).append("\n");
                break;
            case 2:
                bibliotecaApp.exit();
                break;
            case 3:
                message.append(bibliotecaApp.checkOutBook());
                listOfBooks = message.toString().split(",");
                message = new StringBuilder();
                for (String item : listOfBooks)
                    message.append(item).append("\n");
                break;
            case 4:
                message.append(bibliotecaApp.returnBook());
                listOfBooks = message.toString().split(",");
                message = new StringBuilder();
                for (String item : listOfBooks)
                    message.append(item).append("\n");
                break;
            default:
                message = new StringBuilder("Please select a valid option!");
        }
        System.out.println(message.toString().trim());
    }
}
