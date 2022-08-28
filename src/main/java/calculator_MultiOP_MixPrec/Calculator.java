package calculator_MultiOP_MixPrec;

import util.InputParsing;
import java.util.ArrayList;

public class Calculator {

    public Double evaluate(String arguments) throws Exception {
        ArrayList<String> seperatedArgumentList = InputParsing.separateArguments(arguments);
        if (!InputParsing.isValidInput(seperatedArgumentList)) {
            throw new Exception("Please only enter numbers followed by an operator with a number in the ending.");
        }

        boolean containsMultiOrDiv = true; //Tracking * and / as they have precedence
        while (containsMultiOrDiv) {
            boolean found = false;
            for (int i = 0; i < (seperatedArgumentList.size()-1)/2; ++i) { //Amount of loops is based on amount of operators, hence (arguments-1)/2 so rest of .get(i) has to be *2
                if (seperatedArgumentList.get(1+(i*2)).charAt(0) == '*' || seperatedArgumentList.get(1+(i*2)).charAt(0) == '/') {  //Operator is always in uneven placement hence 1+(i*2)
                    double currentValue = calculate(
                            Double.parseDouble(seperatedArgumentList.get(i*2)),
                            seperatedArgumentList.get(1+(i*2)).charAt(0),
                            Double.parseDouble(seperatedArgumentList.get(2+(i*2)))
                    );
                    seperatedArgumentList.remove(i*2);  //Remove calculated number left of operator
                    seperatedArgumentList.remove(i*2);  //Remove used operator
                    seperatedArgumentList.set(i*2, ""+currentValue); //Replace second number with new sum
                    found = true;
                    break;
                }
            }
            containsMultiOrDiv = found;
        }

        if (seperatedArgumentList.size() == 1) {
            return Double.parseDouble(seperatedArgumentList.get(0));
        }
        double currentValue = calculate(
                Double.parseDouble(seperatedArgumentList.get(0)),
                seperatedArgumentList.get(1).charAt(0),
                Double.parseDouble(seperatedArgumentList.get(2))
        );
        for (int i = 0; i < ((seperatedArgumentList.size()-3)/2); ++i) { //First calculation is already done hence -3
            currentValue = calculate(currentValue, seperatedArgumentList.get(3+(i*2)).charAt(0), Double.parseDouble(seperatedArgumentList.get(4+(i*2))));
        }
        return currentValue;
    }

    private double calculate(double lhs, char operator, double rhs) throws Exception {
        switch (operator) {
            case '+':
                return lhs + rhs;
            case '-':
                return lhs - rhs;
            case '*':
                return lhs * rhs;
            case '/':
                return lhs / rhs;
        }
        throw new Exception("Invalid operator");
    }
}
