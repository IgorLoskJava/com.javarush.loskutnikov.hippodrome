import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {

    @Test
    public void hippodromeConstructorNullException() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }

    @Test
    public void hippodromeConstructorNullMessageException() {
        try {
            new Hippodrome(null);
        } catch (IllegalArgumentException e) {
            assertEquals("Horses cannot be null.", e.getMessage());
        }
    }

    @Test
    public void hippodromeConstructorEmptyListException() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
    }

    @Test
    public void hippodromeConstructorEmptyListMessageException() {
        try {
            new Hippodrome(new ArrayList<>());
        } catch (IllegalArgumentException e) {
            assertEquals("Horses cannot be empty.", e.getMessage());
        }
    }

}