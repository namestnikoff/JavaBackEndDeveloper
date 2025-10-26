// ProjectCollector.java
import java.io.*;
import java.nio.file.*;
import java.util.Date;

public class ProjectCollector {
    
    public static void main(String[] args) {
        String outputFile = "project_complete.txt";
        
        try {
            collectProject(outputFile);
            System.out.println("✅ Проект собран в файл: " + outputFile);
        } catch (IOException e) {
            System.err.println("❌ Ошибка при сборке проекта: " + e.getMessage());
        }
    }
    
    public static void collectProject(String outputFile) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            writer.println("=== ПОЛНЫЙ ПРОЕКТ СОБРАН: " + new Date() + " ===");
            writer.println();
            
            Files.walk(Paths.get("."))
                .filter(path -> {
                    String fileName = path.getFileName().toString();
                    return fileName.endsWith(".java") && 
                           !fileName.equals("ProjectCollector.java") &&
                           !path.toString().contains(".git");
                })
                .forEach(path -> {
                    try {
                        writer.println("=== ФАЙЛ: " + path + " ===");
                        writer.println();
                        
                        Files.lines(path).forEach(writer::println);
                            
                        writer.println();
                        writer.println("=== КОНЕЦ ФАЙЛА: " + path + " ===");
                        writer.println();
                    } catch (IOException e) {
                        System.err.println("Ошибка чтения файла: " + path);
                    }
                });
        }
    }
}