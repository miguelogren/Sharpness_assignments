package main;

import try_Anagram.Try_Anagram;
import webpage_LinkFinder.Linkfinder;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean running = true;

        while (running){

            System.out.println("Welcome!\nPlease pick the program you want to run.\n" +
                    "1: Try for anagrams.\n" +
                    "2: Check amount of hyperlinks on webpage.\n" +
                    "3: Calculate with precisely one operator.\n" +
                    "4: Calculate with operators of the same precedence.\n" +
                    "5: Calculate generic.\n" +
                    "X: Exit.");

            Scanner scanner = new Scanner(System.in);
            String stringLine = scanner.nextLine();

            if (stringLine.length() != 1) {
                System.out.println("Please only enter a character from the menu.");
                continue;
            }
            switch (stringLine.toLowerCase()) {
                case "1":
                    Anagram(scanner);
                    break;
                case "2":
                    WebLinkFinder(scanner);
                    break;
                case "3":
                    Calculator_OneOP(scanner);
                    break;
                case "4":
                    Calculator_MultiOP_SamePrec(scanner);
                    break;
                case "5":
                    Calculator_MultiOP_MixPrec(scanner);
                    break;
                case "x":
                    System.out.println("Thank you for playing.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }
    public static void Anagram(Scanner scanner) {
        
        Try_Anagram try_anagram = new Try_Anagram();

        System.out.println("Please enter the first word: ");
        String word1 = scanner.nextLine();
        System.out.println("Please enter the second word: ");
        String word2 = scanner.nextLine();

        if (try_anagram.isAnagram(word1, word2)){
            System.out.println(word1 + " and " + word2 + " are anagrams.");
        }
        else {
            System.out.println(word1 + " and " + word2 + " are not anagrams.");
        }
    }
    public static void WebLinkFinder(Scanner scanner) {
        Linkfinder web_linkfinder = new Linkfinder();
        System.out.println("Please enter a webpage: ");
        String URL = scanner.nextLine();
        web_linkfinder.linkfinder(URL);
    }
    public static void Calculator_OneOP(Scanner scanner) {
        calculator_OneOP.Calculator calc_oneOp = new calculator_OneOP.Calculator();
        System.out.println("Please enter a calculation with 2 numbers and one operator: ");
        String calculation = scanner.nextLine();
        try {
            System.out.println(calc_oneOp.evaluate(calculation));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static void Calculator_MultiOP_SamePrec(Scanner scanner) {
        calculator_MultiOP_SamePrec.Calculator calc_samePrec = new calculator_MultiOP_SamePrec.Calculator();
        System.out.println("Please enter a calculation with the same precedence: ");
        String calculation = scanner.nextLine();
        try {
            System.out.println(calc_samePrec.evaluate(calculation));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static void Calculator_MultiOP_MixPrec(Scanner scanner) {
        calculator_MultiOP_MixPrec.Calculator calc_mixPrec = new calculator_MultiOP_MixPrec.Calculator();
        System.out.println("Please enter a calculation: ");
        String calculation = scanner.nextLine();
        try {
            System.out.println(calc_mixPrec.evaluate(calculation));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
