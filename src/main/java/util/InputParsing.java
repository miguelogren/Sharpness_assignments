package util;

import java.util.ArrayList;

public class InputParsing {
    public static boolean isValidInput(ArrayList<String> input) {
        if (input.size()%2 == 0) {
            return false;
        }
        //TODO: fix - prefix, doesn't allow negative values
        boolean checkNumber = true;

        for (int i = 0; i < input.size(); ++i) {
            String currentInput = input.get(i);
            if (checkNumber) {
                try {
                    Double.parseDouble(currentInput);
                }
                catch (Exception e) {
                    return false;
                }
            }
            else if (!isOperator(currentInput.charAt(0))) {
                return false;
            }
            checkNumber = !checkNumber;
        }
        return true;
    }
    public static ArrayList<String> separateArguments(String arguments) {

        ArrayList<String> argumentList = new ArrayList<>();
        String currentArgument = "";

        for (int i = 0; i < arguments.length(); ++i) {
            char ch = arguments.charAt(i);
            if (isSeparator(ch)) {
                if (currentArgument.length() > 0) {
                    argumentList.add(currentArgument);
                    currentArgument = "";
                }
                if (isOperator(ch)) {
                    argumentList.add(""+ch);
                }
            }
            else {
                currentArgument += ch;
            }
        }
        if (currentArgument.length() > 0) {
            argumentList.add(currentArgument);
        }
        return argumentList;
    }
    public static boolean isSeparator(char ch) {
        if (ch == ' ' || isOperator(ch)) {
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean isOperator(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            return true;
        }
        else {
            return false;
        }
    }
}
