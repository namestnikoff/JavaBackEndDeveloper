public class ArrayGenerator {
    
    // Метод для заполнения массива случайными числами (0-100 для целых, 0-1 для дробных)
    public static int[] fillIntArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 101); // числа от 0 до 100
        }
        return array;
    }
    
    public static double[] fillDoubleArray(int size) {
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = Math.random(); // числа от 0.0 до 1.0
        }
        return array;
    }
}