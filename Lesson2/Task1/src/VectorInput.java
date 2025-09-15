import java.util.Scanner;

public class VectorInput {
    private Scanner scanner;

    public VectorInput() {
        this.scanner = new Scanner(System.in);
    }

    public Vector inputVector(String vectorName) {
        System.out.println("=== Ввод координат вектора " + vectorName + " ===");
        
        double x = inputCoordinate("x");
        double y = inputCoordinate("y");
        double z = inputCoordinate("z");
        
        return new Vector(x, y, z);
    }

    private double inputCoordinate(String coordinateName) {
        System.out.print("Введите координату " + coordinateName + ": ");
        while (true) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                String invalidInput = scanner.next();
                System.out.println("Ошибка: '" + invalidInput + "' не является числом");
                System.out.print("Введите координату " + coordinateName + ": ");
            }
        }
    }

    // Метод для ввода количества векторов N
    public int inputN() {
        System.out.print("Введите количество векторов N: ");
        while (true) {
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                if (n > 0) {
                    return n;
                } else {
                    System.out.println("Ошибка: N должно быть положительным числом");
                }
            } else {
                String invalidInput = scanner.next();
                System.out.println("Ошибка: '" + invalidInput + "' не является целым числом");
            }
            System.out.print("Введите количество векторов N: ");
        }
    }

    public void close() {
        scanner.close();
    }
}