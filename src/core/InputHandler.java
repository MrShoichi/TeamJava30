package utils;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public int safeIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Ошибка: введите целое число.");
                scanner.next();
            }
        }
    }

    public double safeDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Ошибка: введите число.");
                scanner.next();
            }
        }
    }

    public String safeStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    public boolean safeBooleanInput(String prompt) {
        while (true) {
            System.out.print(prompt + " (true/false): ");
            if (scanner.hasNextBoolean()) {
                return scanner.nextBoolean();
            } else {
                System.out.println("Ошибка: введите true или false.");
                scanner.next();
            }
        }
    }

    public int safeMenuChoice(String prompt, int min, int max) {
        while (true) {
            int choice = safeIntInput(prompt);
            if (choice >= min && choice <= max) {
                return choice;
            } else {
                System.out.println("Ошибка: выберите значение от " + min + " до " + max + ".");
            }
        }
    }
}
