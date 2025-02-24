import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class HorseTest {

    @Test
    public void horseNullNameException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1, 1));
    }
    @Test
    public void horseNullMessageException() {}
}