import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserCustomer {
    public static void main(String[] args) throws IOException {
        BibliotecaApp bibliotecaApp;
        Menu menu;
        BufferedReader bufferedReader;

        bibliotecaApp = new BibliotecaApp();
        menu = Menu.getInstance();
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        bibliotecaApp.showWelcomeMessage();
        while (true) {
            System.out.println("Enter your choice:");
            System.out.println(menu.getOptions());
            int choice = (Integer.parseInt(bufferedReader.readLine()));
            String result = menu.enterOption(bibliotecaApp, choice);
            System.out.println(result);
        }

    }
}
