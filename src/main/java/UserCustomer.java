import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserCustomer {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BibliotecaApp bibliotecaApp = new BibliotecaApp(System.out);
        bibliotecaApp.startApp();
    }
}
