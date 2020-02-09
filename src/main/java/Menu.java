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

    public List<String> enterOption(BibliotecaApp bibliotecaApp, int optionNumber) {
        if (optionNumber == 1) {
            return bibliotecaApp.showBooks();
        }
        return null;
    }
}
