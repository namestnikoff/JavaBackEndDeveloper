public class VectorApp {
    public static void main(String[] args) {
        VectorInput input = new VectorInput();
        VectorOutput output = new VectorOutput();
        
        System.out.println("=== Тестирование ввода и вывода векторов ===");
        
        // Ввод одного вектора
        Vector vector1 = input.inputVector("A");
        output.printVector("Вектор A", vector1);
        
        System.out.println();
        
        // Ввод второго вектора
        Vector vector2 = input.inputVector("B");
        output.printVector("Вектор B", vector2);
        
        System.out.println();
        
        // Создание массива векторов
        Vector[] vectors = {vector1, vector2};
        output.printVectors("Все векторы", vectors);
        
        input.close();
    }
}