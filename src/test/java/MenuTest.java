import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuTest {
    @Test
    void shouldShowMenuOptions() {
        Menu menu = Menu.getInstance();
        List<String> expectedMenuOptions = new ArrayList<>(Collections.singletonList(
                "1. Show Available Books"
        ));

        List<String> actualMenuOptions = menu.getOptions();

        assertEquals(expectedMenuOptions, actualMenuOptions);
    }
}