package utils;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int safeIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }

    public double safeDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число.");
            }
        }
    }

    public String safeStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public boolean safeBooleanInput(String prompt) {
        while (true) {
            System.out.print(prompt + " (true/false): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true")) {
                return true;
            } else if (input.equals("false")) {
                return false;
            } else {
                System.out.println("Ошибка: введите true или false.");
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
