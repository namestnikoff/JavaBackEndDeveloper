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

    public void close() {
        scanner.close();
    }
}