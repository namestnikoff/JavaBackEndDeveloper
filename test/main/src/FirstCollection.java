import java.util.*;

public class FirstCollection {
    public static void main(String[] args) {
        // Using Collection interface as type
        Collection<String> fruits = new ArrayList<>();
        
        // Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        
        // Print all elements
        System.out.println("All fruits: " + fruits);
        
        // Check operations
        System.out.println("Size: " + fruits.size());
        System.out.println("Contains Apple: " + fruits.contains("Apple"));
        
        // Remove element
        fruits.remove("Banana");
        System.out.println("After removal: " + fruits);
        
        // Process all elements
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }
    }
}