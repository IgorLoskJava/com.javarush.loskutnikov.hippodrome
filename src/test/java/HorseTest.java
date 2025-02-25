import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
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
    @ValueSource(strings = {"", "   ", "\t", "\t\t", "\n", "\n\n\n\n"})
    public void horseConstructorTabSpaceException(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Horse(name, 1, 1));

    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "\t", "\t\t", "\n", "\n\n\n\n"})
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

    @Test
    public void horseConstructorGetName() throws NoSuchFieldException, IllegalAccessException {
        Horse horse = new Horse("Horse", 1, 1);
        Field name = Horse.class.getDeclaredField("name");
        name.setAccessible(true);
        String firstParam = (String) name.get(horse);
        assertEquals("Horse", firstParam);
    }

    @Test
    public void horseConstructorGetSpeed() throws NoSuchFieldException, IllegalAccessException {
        Horse horse = new Horse("Horse", 1, 1);
        Field speed = Horse.class.getDeclaredField("speed");
        speed.setAccessible(true);
        double secondParam = (double) speed.get(horse);
        assertEquals(1.0, secondParam);

    }

    @Test
    public void horseConstructorGetDistanceThirdParam() throws NoSuchFieldException, IllegalAccessException {
        Horse horse = new Horse("Horse", 1, 1);
        assertEquals(1, horse.getDistance());
    }

    @Test
    public void horseConstructorTwoParamGetDistance() throws NoSuchFieldException, IllegalAccessException {
        Horse horse = new Horse("Horse", 1);
        assertEquals(0, horse.getDistance());
    }

    @Test
    public void moveGetRandomDouble() {
        try (MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class)) {
            Horse horse = new Horse("Horse", 1);
            horse.move();
            mockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));

        }
    }

//    @Test
//    public void moveGetRandomDistance() {
//        try (MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class)) {
//            Horse horse = new Horse("Horse", 1, 1);
//            mockedStatic.when(Horse.getRandomDouble(0.2, 0.9)).then(Horse.class)
//        }
//    }

}