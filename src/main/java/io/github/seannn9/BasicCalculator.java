package io.github.seannn9;
import java.util.Scanner;

public class BasicCalculator {
    public static void run(Scanner scanner) {
        int num1, num2;
        String operation;

        System.out.println("\nBasic Calculator");
        do {
            System.out.print("Choose an operation? + - * /: ");
            operation = scanner.nextLine().trim();
        } while (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/"));

        do {
            try {
                System.out.print("Enter first number: ");
                num1 = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter second number: ");
                num2 = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException err) {
                System.out.println(err + "Enter a valid number.\n");
            }
        } while (true);

        switch(operation) {
            case "+":
                System.out.println("Sum: " + (num1 + num2));
                break;
            case "-":
                System.out.println("Difference: " + (num1 - num2));
                break;
            case "*":
                System.out.println("Product: " + num1 * num2);
                break;
            case "/":
                System.out.println("Quotient: " + num1 / num2);
                break;   
        }
    }
}
