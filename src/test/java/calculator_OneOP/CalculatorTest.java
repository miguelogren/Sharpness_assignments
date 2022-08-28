package calculator_OneOP;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calc = new Calculator();

    @Test
    void evaluate() throws Exception {

        String correct1 = "1 +11";
        String correct2 = " 9 * 9 ";
        String incorrect1 = "-1 + 1";

        double expectedCorrect1 = 12.0;
        double expectedCorrect2 = 81.0;

        assertEquals(calc.evaluate(correct1), expectedCorrect1);
        assertEquals(calc.evaluate(correct2), expectedCorrect2);

        try {
            calc.evaluate(incorrect1);
            assertFalse(true);
        }
        catch (Exception exception) {
            assertTrue(true);
        }

        assertNotEquals(correct1, expectedCorrect2);
    }
}