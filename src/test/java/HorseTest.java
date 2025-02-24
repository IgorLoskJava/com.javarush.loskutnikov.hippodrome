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
}