import java.util.Scanner;
import java.util.Arrays;

public class ArrayOperations {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String promt = "Введите размер массива";        
        // Ввод размера массива
        int size = InputHandler.getPositiveInt(scanner,promt);
        System.out.println(size);
        // Выбор типа данных
        int dataType = InputHandler.getChoice(scanner, 
            "Выберите тип данных:\n1 - Целочисленные значения (int)\n2 - Дробные значения (double)", 
            1, 2);
        System.out.println(dataType);
        if (dataType == 1) {
        // Целочисленный массив
            int[] intArray = ArrayGenerator.fillIntArray(size);
            ArrayPrinter.printResults(intArray);
        // Сортировка
            int[] sortedAsc = intArray.clone();
            ArrayProcessor.sortAscending(sortedAsc);
            System.out.println("Отсортированный по возрастанию: " + Arrays.toString(sortedAsc));
            
            int[] sortedDesc = intArray.clone();
            ArrayProcessor.sortDescending(sortedDesc);
            System.out.println("Отсортированный по убыванию: " + Arrays.toString(sortedDesc));
        }else {
            // Дробный массив
            double[] doubleArray = ArrayGenerator.fillDoubleArray(size);
            ArrayPrinter.printResults(doubleArray);
            // Сортировка
            double[] sortedAsc = doubleArray.clone();
            ArrayProcessor.sortAscending(sortedAsc);
            System.out.println("Отсортированный по возрастанию: " + Arrays.toString(sortedAsc));
            double[] sortedDesc = doubleArray.clone();
            ArrayProcessor.sortDescending(sortedDesc);
            System.out.println("Отсортированный по убыванию: " + Arrays.toString(sortedDesc));
        }         
        scanner.close();
    }
}