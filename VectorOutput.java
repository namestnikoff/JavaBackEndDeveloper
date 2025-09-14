public class VectorOutput {
    
    public void printVector(String name, Vector vector) {
        System.out.println(name + " = " + vector);
        System.out.println("Координаты: x = " + vector.getX() + 
                         ", y = " + vector.getY() + 
                         ", z = " + vector.getZ());
    }

    public void printVectors(String title, Vector[] vectors) {
        System.out.println("=== " + title + " ===");
        for (int i = 0; i < vectors.length; i++) {
            System.out.println((i + 1) + ". " + vectors[i]);
        }
    }
}