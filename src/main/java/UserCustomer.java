import java.io.IOException;

public class UserCustomer {
    public static void main(String[] args) throws IOException {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new Console(System.out));
        bibliotecaApp.startApp();
    }
}
