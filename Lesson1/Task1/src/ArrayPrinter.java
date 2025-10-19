import java.util.Arrays;

public class ArrayPrinter {
    
    // Методы для вывода массивов
    public static void printArray(int[] array) {
        System.out.println("Массив: " + Arrays.toString(array));
    }
    
    public static void printArray(double[] array) {
        System.out.println("Массив: " + Arrays.toString(array));
    }
    
    public static void printResults(int[] array) {
        printArray(array);
        System.out.println("Максимальное значение: " + ArrayProcessor.findMax(array));
        System.out.println("Минимальное значение: " + ArrayProcessor.findMin(array));
        System.out.println("Среднее значение: " + ArrayProcessor.findAverage(array));
    }
    
    public static void printResults(double[] array) {
        printArray(array);
        System.out.println("Максимальное значение: " + ArrayProcessor.findMax(array));
        System.out.println("Минимальное значение: " + ArrayProcessor.findMin(array));
        System.out.println("Среднее значение: " + ArrayProcessor.findAverage(array));
    }
}
