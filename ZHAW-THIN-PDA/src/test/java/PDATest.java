import org.example.PDACalculator;
import org.junit.jupiter.api.Test;

import java.util.InvalidPropertiesFormatException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PDATest {

    private PDACalculator calculator = new PDACalculator();

    @Test
    void acceptingTestOne() throws InvalidPropertiesFormatException {
        assertEquals("664", calculator.calculate("3 4 + 6 2 + 8 9 + 4 3 + * * *"));
    }

    @Test
    void acceptingTestTwo() throws InvalidPropertiesFormatException {
        assertEquals("58", calculator.calculate("3 1 + 7 8 + 9 8 7 + 1 2 1 4 + + 7 + + + + + +"));
    }

    @Test
    void rejectingTestOne() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("3 4 + *"));
    }

    @Test
    void rejectingTestTwo() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("8 + 9 + 7 * 2 *"));
    }
}
