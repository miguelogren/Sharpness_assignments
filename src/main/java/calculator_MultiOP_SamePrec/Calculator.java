package calculator_MultiOP_SamePrec;

import util.InputParsing;
import java.util.ArrayList;

public class Calculator {

    public Double evaluate(String arguments) throws Exception {
        ArrayList<String> seperatedArgumentList = InputParsing.separateArguments(arguments);
        if (!InputParsing.isValidInput(seperatedArgumentList)){
            throw new Exception("Please check your input, only enter numbers followed by operators with the same precedence.");
        }

        boolean masterOperator = true; //Defines the operator pair allowed i.e. +- or */
        if (seperatedArgumentList.get(1).charAt(0) == '*' || seperatedArgumentList.get(1).charAt(0) == '/') {
            masterOperator = false;
        }

        double currentValue = calculate(
                Double.parseDouble(seperatedArgumentList.get(0)),
                seperatedArgumentList.get(1).charAt(0),
                Double.parseDouble(seperatedArgumentList.get(2)),
                masterOperator
        );
        for (int i = 0; i < ((seperatedArgumentList.size()-3)/2); ++i) { //Arguments -2 to skip first finished calculation, -1 to align operators and numbers and /2 to get only operators
            currentValue = calculate(
                    currentValue,
                    seperatedArgumentList.get(3+(i*2)).charAt(0),
                    Double.parseDouble(seperatedArgumentList.get(4+(i*2))),
                    masterOperator
            );
        }
        return currentValue;
    }

    private double calculate(double lhs, char operator, double rhs, boolean masterOperator) throws Exception {
        if (masterOperator) {
            switch (operator) {
                case '+':
                    return lhs + rhs;
                case '-':
                    return lhs - rhs;
            }
        }
        else {
            switch (operator) {
                case '*':
                    return lhs * rhs;
                case '/':
                    return lhs / rhs;
            }
        }
        throw new Exception("Invalid operator");
    }
}
