package calculator_MultiOP_MixPrec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void evaluate() throws Exception {

        String correct1 = "1/1*2";
        String correct2 = " 9 * 9 ";
        String incorrect1 = "1+2*3";
        String incorrect2 = "1+2+";

        double expectedCorrect1 = 2.0;
        double expectedCorrect2 = 81.0;
        double expectedIncorrect1 = 9.0;

        assertEquals(calc.evaluate(correct1), expectedCorrect1);
        assertEquals(calc.evaluate(correct2), expectedCorrect2);
        assertNotEquals(calc.evaluate(incorrect1), expectedIncorrect1);

        try {
            calc.evaluate(incorrect2);
            fail();
        }
        catch (Exception exception) {
            assertTrue(true);
        }
    }
}