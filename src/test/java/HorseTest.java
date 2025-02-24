import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    public void horseConstructorNullNameException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1, 1));
    }

    @Test
    public void horseConstructorNullMessageException() {
        try {
            new Horse(null, 1, 1);
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be null.", e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"","   ","\t","\t\t","\n","\n\n\n\n"})
    public void horseConstructorTabSpaceException(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Horse(name, 1, 1));

    }

    @ParameterizedTest
    @ValueSource(strings = {"","   ","\t","\t\t","\n","\n\n\n\n"})
    public void horseConstructorTabSpaceMessageException(String name) {
        try {
            new Horse(name, 1, 1);
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be blank.", e.getMessage());
        }
    }

    @Test
    public void horseConstructorSecondException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse("Horse", -5, 1));
    }
    @Test
    public void horseConstructorSecondMessageException() {
        try {
            new Horse("Horse", -5, 1);
        } catch (IllegalArgumentException e) {
            assertEquals("Speed cannot be negative.", e.getMessage());
        }
    }
    @Test
    public void horseConstructorThirdException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse("Horse", 1, -5));
    }
    @Test
    public void horseConstructorThirdMessageException() {
        try {
            new Horse("Horse", 1, -5);
        } catch (IllegalArgumentException e) {
            assertEquals("Distance cannot be negative.", e.getMessage());
        }
    }
}