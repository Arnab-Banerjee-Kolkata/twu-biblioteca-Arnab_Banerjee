import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MenuTest {
    Menu menu;
    BookLibrary bookLibrary;
    BibliotecaApp bibliotecaApp;
    MovieLibrary movieLibrary;

    @BeforeEach
    void setUp() {
        menu = new Menu(new Console(System.out));
        bookLibrary = mock(BookLibrary.class);
        bibliotecaApp = mock(BibliotecaApp.class);
        movieLibrary = mock(MovieLibrary.class)
        ;
    }

    @Test
    void shouldShowMenuOptions() {
        List<String> expectedMenuOptions = new ArrayList<>(Arrays.asList(
                "1. Show Available Books",
                "\n2. Exit",
                "\n3. Checkout",
                "\n4. Return",
                "\n5. Show Available Movies"
        ));

        List<String> actualMenuOptions = menu.getOptions();

        assertEquals(expectedMenuOptions, actualMenuOptions);
    }

    @Test
    void shouldShowBookListIfOneIsEntered() throws IOException {
        menu.enterOption(bibliotecaApp, bookLibrary, movieLibrary, 1);

        verify(bookLibrary, times(1)).showBooks();
    }

    @Test
    void shouldShowMessageWhenInvalidOptionIsEntered() throws IOException {
        String expectedMessage = "Please select a valid option!";

        String actualMessage = menu.enterOption(bibliotecaApp, bookLibrary, movieLibrary, -1);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void shouldCallExitFunctionalityOfLibraryWhenExitOptionIsEntered() throws IOException {
        menu.enterOption(bibliotecaApp, bookLibrary, movieLibrary, 2);

        verify(bibliotecaApp, times(1)).exit();
    }

    @Test
    void shouldCallCheckOutFunctionalityOfLibraryOnEnteringCheckOutOption() throws IOException {
        String simulatedInput = "Book_Name_2\nAuthor_Name_2\n1987";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        menu.enterOption(bibliotecaApp, bookLibrary, movieLibrary, 3);

        verify(bookLibrary, times(1)).checkOutBook(new Book("Book_Name_2", "Author_Name_2", 1987));
    }

    @Test
    void shouldCallReturnBookFunctionOfLibraryOnReturningBook() throws IOException {
        String simulatedInput = "Book_Name_2\nAuthor_Name_2\n1987";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        menu.enterOption(bibliotecaApp, bookLibrary, movieLibrary, 4);

        verify(bookLibrary, times(1)).returnBook(new Book("Book_Name_2", "Author_Name_2", 1987));
    }

    @Test
    void shouldShowMoviesOnSelectingShowMoviesOption() throws IOException {
        menu.enterOption(bibliotecaApp, bookLibrary, movieLibrary, 5);

        verify(movieLibrary, times(1)).showMovies();

    }
}