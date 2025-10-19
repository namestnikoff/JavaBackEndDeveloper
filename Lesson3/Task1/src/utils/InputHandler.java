package utils;
import java.util.Scanner;

public class InputHandler {
    
    // Для целых чисел в диапазоне
    public static int getInt(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                scanner.nextLine(); // очистка буфера
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("Пожалуйста, введите число от " + min + " до " + max);
                }
            } else {
                String invalidInput = scanner.next();
                System.out.println("'" + invalidInput + "' не является целым числом");
            }
        }
    }
    
    // Для положительных целых чисел
    public static int getPositiveInt(Scanner scanner, String prompt) {
        return getInt(scanner, prompt, 1, Integer.MAX_VALUE);
    }
    
    // Для строк
    public static String getString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    
    // Для double чисел
    public static double getDouble(Scanner scanner, String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double input = scanner.nextDouble();
                scanner.nextLine(); // очистка буфера
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("Пожалуйста, введите число от " + min + " до " + max);
                }
            } else {
                String invalidInput = scanner.next();
                System.out.println("'" + invalidInput + "' не является числом");
            }
        }
    }
    
    // Для boolean (да/нет)
    public static boolean getBoolean(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt + " (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("yes") || input.equals("д") || input.equals("да")) {
                return true;
            } else if (input.equals("n") || input.equals("no") || input.equals("н") || input.equals("нет")) {
                return false;
            } else {
                System.out.println("Пожалуйста, введите 'y' (да) или 'n' (нет)");
            }
        }
    }
    
    // Для выбора из enum
    public static <T extends Enum<T>> T getEnumChoice(Scanner scanner, String prompt, Class<T> enumClass) {
        T[] values = enumClass.getEnumConstants();
        System.out.println(prompt);
        for (int i = 0; i < values.length; i++) {
            System.out.println((i + 1) + ". " + values[i]);
        }
        
        int choice = getInt(scanner, "Выберите вариант: ", 1, values.length);
        return values[choice - 1];
    }
}