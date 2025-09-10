package io.github.seannn9;

import java.util.Scanner;

public class MultiplicationTable {
    public static void run(Scanner scanner) {
        int multiplier, multiplicand;
        System.out.println("\nMultiplication Table\n");

        do {
            try {
                System.out.print("Enter a multiplier: ");
                multiplier = Integer.parseInt(scanner.nextLine());
                System.out.print("Multiply up to? ");
                multiplicand = Integer.parseInt(scanner.nextLine());
                break;
            } catch(NumberFormatException e) {
                System.out.println("Please input a number");
            }
        } while (true);

        for (int i = 1; i <= multiplicand; i++) {
            int product = multiplier * i;
            System.out.println(multiplier + " x " + i + " = " + product);
        }
        System.out.println();
    }
}
