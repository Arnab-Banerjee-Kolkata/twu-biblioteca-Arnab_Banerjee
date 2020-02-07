import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BibliotecaAppTest {

    @Test
    void shouldShowWelcomeMessageWhenAppIsStarted() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        String welcomeMessage = bibliotecaApp.showWelcomeMessage();

        Assertions.assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", welcomeMessage);
    }


}