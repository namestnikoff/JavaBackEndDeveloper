public class VectorApp {
    public static void main(String[] args) {
        VectorInput input = new VectorInput();
        VectorOutput output = new VectorOutput();
        
        System.out.println("=== Тестирование ввода и вывода векторов ===");
        
        // Ввод одного вектора
        Vector vector1 = input.inputVector("A");
        output.printVector("Вектор A", vector1);

        // Ввод второго вектора
        Vector vector2 = input.inputVector("B");
        output.printVector("Вектор B", vector2);
                
        System.out.println("=== РЕЗУЛЬТАТЫ ВЫЧИСЛЕНИЙ ===");
        // Длина вектора
        System.out.println("Длина вектора A: " + String.format("%.2f", vector1.length()));      
        System.out.println("Длина вектора B: " + String.format("%.2f", vector2.length()));
            
        // Скалярное произведение
        double dotProduct = vector1.dotProduct(vector2);
        System.out.println("Скалярное произведение A·B: " + String.format("%.2f", dotProduct));
        
        // Векторное произведение
        Vector crossProduct = vector1.crossProduct(vector2);
        output.printVector("Векторное произведение AxB", crossProduct);
        
        // Косинус угла
        try {
            double cosAngle = vector1.cosAngle(vector2);
            System.out.println("Косинус угла между A и B: " + String.format("%.4f", cosAngle));
        } catch (ArithmeticException e) {
            System.out.println("Невозможно вычислить косинус угла: " + e.getMessage());
        }
        
        // Угол между векторами
        try {
            double angle = vector1.angle(vector2);
            System.out.println("Угол между A и B: " + String.format("%.2f", angle) + " радиан (" + 
                            String.format("%.2f", Math.toDegrees(angle)) + " градусов)");
        } catch (ArithmeticException e) {
            System.out.println("Невозможно вычислить угол: " + e.getMessage());
        }
        
        // Сумма векторов
        Vector sum = vector1.add(vector2);
        output.printVector("Сумма A+B", sum);
        
        // Разность векторов
        Vector difference = vector1.subtract(vector2);
        output.printVector("Разность A-B", difference);
        
        // Создание массива векторов
        Vector[] vectors = {vector1, vector2, crossProduct, sum, difference};
        output.printVectors("Все векторы", vectors);
        
        input.close();
    }
}