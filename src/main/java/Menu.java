import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Menu {
    private static Menu menu;
    private List<String> menuOptions;

    private Menu() {
    }

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
            menu.menuOptions = new ArrayList<>(Collections.singletonList("1. Show Available Books"));
        }
        return menu;
    }

    public List<String> getOptions() {
        return this.menuOptions;
    }

    public String enterOption(BibliotecaApp bibliotecaApp, int optionNumber) {
        String message = "Please select a valid option!";
        if (optionNumber == 1) {
            bibliotecaApp.showBooks();
        }
        return message;
    }
}
