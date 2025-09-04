package io.github.seannn9;

public class FizzBuzz {
    public static void run() {
        System.out.print("(1)");
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.print(" Fizz\t");
            } else if (i % 5 == 0) {
                System.out.print(" Buzz\t");
            } else {
                System.out.print(" " + i + "\t");
            }

            if (i != 100 && i % 10 == 0) {
                System.out.println();
                System.out.print("(" + ((i / 10)+1) + ")");
            }
        }
        System.out.println();
    }
}
