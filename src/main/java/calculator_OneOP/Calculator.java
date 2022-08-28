package calculator_OneOP;

import util.InputParsing;
import java.util.ArrayList;

public class Calculator {

    public Double evaluate(String arguments) throws Exception {
        ArrayList<String> seperatedArgumentList = InputParsing.separateArguments(arguments);
        if (!InputParsing.isValidInput(seperatedArgumentList)){
            throw new Exception("Please only enter 2 different numbers with one operator.");
        }
        if (seperatedArgumentList.size() == 3) {
            return calculate(seperatedArgumentList);
        }
        throw new Exception("Please only enter 2 different numbers with one operator.");
    }

    private double calculate(ArrayList<String> argumentsList) throws Exception {
        switch (argumentsList.get(1).charAt(0)) {
            case '+':
                return Double.parseDouble(argumentsList.get(0)) + Double.parseDouble(argumentsList.get(2));
            case '-':
                return Double.parseDouble(argumentsList.get(0)) - Double.parseDouble(argumentsList.get(2));
            case '*':
                return Double.parseDouble(argumentsList.get(0)) * Double.parseDouble(argumentsList.get(2));
            case '/':
                return Double.parseDouble(argumentsList.get(0)) / Double.parseDouble(argumentsList.get(2));
        }
        throw new Exception("Invalid operator");
    }
}