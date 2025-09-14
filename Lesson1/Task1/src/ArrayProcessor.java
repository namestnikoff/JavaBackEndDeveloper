import java.util.Arrays;

public class ArrayProcessor {
    
    // Перегрузка для целочисленных массивов
    public static int findMax(int[] array) {
        if (array == null || array.length == 0) return 0;
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }
        return max;
    }
    
    public static int findMin(int[] array) {
        if (array == null || array.length == 0) return 0;
        int min = array[0];
        for (int num : array) {
            if (num < min) min = num;
        }
        return min;
    }
    
    public static double findAverage(int[] array) {
        if (array == null || array.length == 0) return 0;
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }
    
    public static void sortAscending(int[] array) {
        Arrays.sort(array);
    }
    
    public static void sortDescending(int[] array) {
        Arrays.sort(array);
        // Разворачиваем массив для сортировки по убыванию
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
    
    // Перегрузка для дробных массивов
    public static double findMax(double[] array) {
        if (array == null || array.length == 0) return 0;
        double max = array[0];
        for (double num : array) {
            if (num > max) max = num;
        }
        return max;
    }
    
    public static double findMin(double[] array) {
        if (array == null || array.length == 0) return 0;
        double min = array[0];
        for (double num : array) {
            if (num < min) min = num;
        }
        return min;
    }
    
    public static double findAverage(double[] array) {
        if (array == null || array.length == 0) return 0;
        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        return sum / array.length;
    }
    
    public static void sortAscending(double[] array) {
        Arrays.sort(array);
    }
    
    public static void sortDescending(double[] array) {
        Arrays.sort(array);
        // Разворачиваем массив для сортировки по убыванию
        for (int i = 0; i < array.length / 2; i++) {
            double temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}
