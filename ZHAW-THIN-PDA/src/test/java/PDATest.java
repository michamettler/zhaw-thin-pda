import org.example.PDACalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PDATest {

    private PDACalculator calculator = new PDACalculator();

    @Test
    void acceptingTest1() {
        assertEquals("6664", calculator.calculate("3 4 + 6 2 + 8 9 + 4 3 + * * *"));
    }

    @Test
    void acceptingTest2() {
        assertEquals("58", calculator.calculate("3 1 + 7 8 + 9 8 7 + 1 2 1 4 + + 7 + + + + + +"));
    }

    @Test
    void acceptingTest3() {
        assertEquals("16", calculator.calculate("2 4 * 8 +"));
    }

    @Test
    void acceptingTest4() {
        assertEquals("24", calculator.calculate("2 4 8 + *"));
    }

    @Test
    void rejectingTestOne() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("3 4 + *"));
    }

    @Test
    void rejectingTestTwo() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("8 + 9 + 7 * 2 *"));
    }

    @Test
    void rejectingTest3() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("2 4 * 8 + +"));
    }

    @Test
    void rejectingTest4() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("2 4 * 8 + *"));
    }

    @Test
    void rejectingTest5() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("* * * * * *"));
    }

}
