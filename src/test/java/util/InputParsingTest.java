package util;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class InputParsingTest {

    @Test
    void isValidInput() {
        
        
        ArrayList<String> incorrect1 = new ArrayList<>(); //+11+2
        ArrayList<String> incorrect2 = new ArrayList<>(); //1+2+
        ArrayList<String> correct1 = new ArrayList<>(); //" 5+ 2545 "
        
        incorrect1.add("+");
        incorrect1.add("1");
        incorrect1.add("1");
        incorrect1.add("+");
        incorrect1.add("2");
        
        incorrect2.add("1");
        incorrect2.add("*");
        incorrect2.add("2");
        incorrect2.add("/");
        
        correct1.add(" 5");
        correct1.add("+ ");
        correct1.add("2545 ");

        assertFalse(InputParsing.isValidInput(incorrect1));
        assertFalse(InputParsing.isValidInput(incorrect2));
        assertTrue(InputParsing.isValidInput(correct1));


    }

    @Test
    void separateArguments() {

        String test1 = " 1 + A */* 2";
        String test2 = "+1+1";

        ArrayList<String> expectedResult1 = new ArrayList<>();
        ArrayList<String> expectedResult2 = new ArrayList<>();

        expectedResult1.add("1");
        expectedResult1.add("+");
        expectedResult1.add("A");
        expectedResult1.add("*");
        expectedResult1.add("/");
        expectedResult1.add("*");
        expectedResult1.add("2");

        expectedResult2.add("+");
        expectedResult2.add("2");
        expectedResult2.add("+");
        expectedResult2.add("1");


        ArrayList<String> result1 = InputParsing.separateArguments(test1);
        boolean equal = true;
        assertTrue(result1.size() == expectedResult1.size());
        for (int i = 0; i < expectedResult1.size(); ++i) {
            String lhs = result1.get(i);
            String rhs = expectedResult1.get(i);
            if (!lhs.equals(rhs)) {
                equal = false;
                break;
            }

        }
        assertTrue(equal);

        ArrayList<String> result2 = InputParsing.separateArguments(test2);
        equal = true;
        assertTrue(result2.size() == expectedResult2.size());
        for (int i = 0; i < expectedResult2.size(); ++i) {
            String lhs = result2.get(i);
            String rhs = expectedResult2.get(i);
            if (!lhs.equals(rhs)) {
                equal = false;
                break;
            }
        }
        assertFalse(equal);

    }

    @Test
    void isSeparator() {
        char correct = ' ';
        char incorrect = 'A';

        //assertTrue(InputParsing.isSeparator(incorrect));
        assertTrue(InputParsing.isSeparator(correct));
        assertFalse(InputParsing.isSeparator(incorrect));
    }

    @Test
    void isOperator() {
        char correct = '+';
        char incorrect = '?';

        assertTrue(InputParsing.isOperator(correct));
        assertFalse(InputParsing.isOperator(incorrect));
    }
}