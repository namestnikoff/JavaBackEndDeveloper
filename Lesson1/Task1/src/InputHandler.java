import java.util.Scanner;
public class InputHandler {
    public static int getPositiveInt(Scanner scanner,String promt){
        System.out.println(promt);        
        int input = -1;
        while (true) {
            if (scanner.hasNextInt()){          
                input = scanner.nextInt();//читает число
                if (input > 0)
                    break;
                else if (input == 0){
                        System.out.println("Вы ввели " + input + ", размер массива не может быть равен нулю");
                }
                else {
                    System.out.println("Размер массива не может быть отрицательным");
                }
            } 
            else {
                String InvalidInput =  scanner.next();
                System.out.println("'" + InvalidInput + "' не является целым числом");
            }                  
        }
        return input;
    }
    public static int getChoice(Scanner scanner, String prompt, int minChoice, int maxChoice) {
        while (true) {
            System.out.println(prompt);
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= minChoice && choice <= maxChoice) {
                    return choice;
                } else {
                    System.out.println("Пожалуйста, введите число от " + minChoice + " до " + maxChoice);
                }
            } else {
                String invalidInput = scanner.next();
                System.out.println("'" + invalidInput + "' не является числом");
            }
        }
    }
}
