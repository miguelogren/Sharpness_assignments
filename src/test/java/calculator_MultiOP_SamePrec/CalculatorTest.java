package calculator_MultiOP_SamePrec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void evaluate() throws Exception {

        String correct1 = "1/1*2";
        String correct2 = " 9 * 9 ";
        String correct3 = "1 + 2- 1";
        String incorrect1 = "1/2*3";
        String incorrect2 = "1+2*3";

        double expectedCorrect1 = 2.0;
        double expectedCorrect2 = 81.0;
        double expectedCorrect3 = 2.0;
        double expectedIncorrect1 = 9.0;

        assertEquals(calc.evaluate(correct1), expectedCorrect1);
        assertEquals(calc.evaluate(correct2), expectedCorrect2);
        assertEquals(calc.evaluate(correct3), expectedCorrect3);
        assertNotEquals(calc.evaluate(incorrect1), expectedIncorrect1);

        try {
            calc.evaluate(incorrect2);
            fail();
        }
        catch (Exception exception) {
            assertTrue(true);
        }


        //TODO test exception due to incorrect input
        //assertThrows(calc.evaluate(incorrect1), e);
    }
}