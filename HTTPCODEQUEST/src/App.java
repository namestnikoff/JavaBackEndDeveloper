import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        HttpStatusDictionary dictionary = new HttpStatusDictionary();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Давай поиграем?\nЯ буду выводить описание, а ты угадай код ошибки\nДля выхода нажми 'q'");
        
        int score = 0;
        int totalQuestions = 0;
        boolean playing = true;
        
        while (playing) {
            // Получаем случайный код и его описание
            int randomCode = dictionary.getRandomStatusCode();
            String description = dictionary.getDescription(randomCode);
            
            System.out.println("\n" + "=".repeat(40));
            System.out.println("Описание: " + description);
            System.out.print("Твой ответ (или 'q' для выхода): ");
            
            String input = scanner.nextLine().trim();
            
            // Проверяем, хочет ли пользователь выйти
            if (input.equalsIgnoreCase("q")) {
                playing = false;
                continue;
            }
            
            try {
                int userAnswer = Integer.parseInt(input);
                totalQuestions++;
                
                if (userAnswer == randomCode) {
                    System.out.println("✅ Правильно! Молодец!");
                    score++;
                } else {
                    System.out.println("❌ Неправильно! Правильный ответ: " + randomCode);
                }
                
                // Показываем текущий счет
                System.out.println("Счет: " + score + "/" + totalQuestions);
                
            } catch (NumberFormatException e) {
                System.out.println("❌ Пожалуйста, введите число или 'q' для выхода");
            }
        }
        
        // Финальные результаты
        System.out.println("\n" + "=".repeat(40));
        System.out.println("Игра окончена!");
        System.out.println("Финальный счет: " + score + "/" + totalQuestions);
        
        if (totalQuestions > 0) {
            double percentage = (double) score / totalQuestions * 100;
            System.out.printf("Процент правильных ответов: %.1f%%\n", percentage);
        }
        
        scanner.close();
    }
}