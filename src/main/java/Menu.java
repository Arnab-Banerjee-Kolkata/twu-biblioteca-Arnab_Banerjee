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

    public String enterOption(BibliotecaApp bibliotecaApp, int optionNumber) throws IOException {
        switch (optionNumber) {
            case 1:
                bibliotecaApp.showBooks();
                break;
            case 2:
                bibliotecaApp.exit();
                break;
            case 3:
                bibliotecaApp.checkOutBook();
            case 4:
                bibliotecaApp.returnBook();
            default:
                return "Please select a valid option!";
        }
        return null;
    }
}
