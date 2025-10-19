//Класс immutable - наследование запрещено

import java.util.Random;

public final class Vector {
    //Наследование атрибутов тоже запрещено и нет сеттеров для изменения атрибутов
    private final double x;
    private final double y;
    private final double z;
    // Добавляем генератор случайных чисел как статическое поле
    private static final Random random = new Random();

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // 1. Метод вычисляющий длину вектора
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    // 2. Скалярное произведение
    public double dotProduct(Vector other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    // 3. Векторное произведение
    public Vector crossProduct(Vector other) {
        double newX = this.y * other.z - this.z * other.y;
        double newY = this.z * other.x - this.x * other.z;
        double newZ = this.x * other.y - this.y * other.x;
        return new Vector(newX, newY, newZ);
    }

    // 4. Косинус угла между векторами
    public double cosAngle(Vector other) {
        double dotProduct = dotProduct(other);
        double thisLength = length();
        double otherLength = other.length();
        
        if (thisLength == 0 || otherLength == 0) {
            throw new ArithmeticException("Cannot compute angle with zero vector");
        }
        
        return dotProduct / (thisLength * otherLength);
    }

    // 5. Угол между векторами в радианах
    public double angle(Vector other) {
        return Math.acos(cosAngle(other));
    }

    // 6. Сумма векторов
    public Vector add(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    // 7. Разность векторов
    public Vector subtract(Vector other) {
        return new Vector(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    // 8.Статический метод для создания массива случайных векторов
    public static Vector[] generateRandomVectors(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Number of vectors must be positive");
        }
        
        Vector[] vectors = new Vector[n];
        for (int i = 0; i < n; i++) {
            // Генерируем случайные координаты в диапазоне [-10.0, 10.0)
            double x = random.nextDouble() * 20 - 10;
            double y = random.nextDouble() * 20 - 10;
            double z = random.nextDouble() * 20 - 10;
            
            vectors[i] = new Vector(x, y, z);
        }
        return vectors;
    }

    // Геттеры
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }
    



    
    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", x, y, z);
    }
}