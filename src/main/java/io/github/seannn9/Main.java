package io.github.seannn9;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] programs = {"FizzBuzz", "Basic Calculator", "Currency Converter"};
        System.out.println("What program would you like to start?");
        for (int i = 1; i <= programs.length; i++) {
            System.out.println(i + ": " + programs[i-1]);
        }
        
        do {
            try {
                System.out.print("Enter the corresponding number: ");
                int program = Integer.parseInt(scanner.nextLine());

                switch(programs[program - 1]) {
                case "FizzBuzz":
                    FizzBuzz.run();
                    break;
                case "Basic Calculator":
                    BasicCalculator.run(scanner);
                    break;
                case "Currency Converter":
                    CurrencyConverter.run(scanner);
                    break;
                default:
                    System.out.println("No program selected");
                    break;
                }
                scanner.close();
                break;
            } catch (NumberFormatException err) {
                System.out.println(err + " Enter a valid option.\n");
            }
        } while (true);  
    }
}