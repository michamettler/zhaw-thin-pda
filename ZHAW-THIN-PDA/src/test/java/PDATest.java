import org.example.Mode;
import org.example.PDACalculator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PDATest {

    private PDACalculator calculator = new PDACalculator();

    @Test
    void acceptingTest1() throws InterruptedException {
        assertEquals("6664", calculator.calculate("3 4 + 6 2 + 8 9 + 4 3 + * * *", Mode.DEFAULT));
    }

    @Disabled
    @Test
    void acceptingTest2() throws InterruptedException {
        assertEquals("58", calculator.calculate("3 1 + 7 8 + 9 8 7 + 1 2 1 4 + + 7 + + + + + +", Mode.STEP_MODE));
    }

    @Test
    void acceptingTest3() throws InterruptedException {
        assertEquals("16", calculator.calculate("2 4 * 8 +", Mode.DEFAULT));
    }

    @Test
    void acceptingTest4() throws InterruptedException {
        assertEquals("24", calculator.calculate("2 4 8 + *", Mode.DEFAULT));
    }

    @Test
    void rejectingTestOne() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("3 4 + *", Mode.DEFAULT));
    }

    @Test
    void rejectingTestTwo() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("8 + 9 + 7 * 2 *", Mode.DEFAULT));
    }

    @Test
    void rejectingTest3() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("2 4 * 8 + +", Mode.DEFAULT));
    }

    @Test
    void rejectingTest4() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("2 4 * 8 + *", Mode.DEFAULT));
    }

    @Test
    void rejectingTest5() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("* * * * * *", Mode.DEFAULT));
    }

}
