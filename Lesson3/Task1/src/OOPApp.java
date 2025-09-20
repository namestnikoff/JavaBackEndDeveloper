import java.util.Scanner;

import utils.InputHandler;
public class OOPApp {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        int number = InputHandler.getInt(scanner, "Введите число: ", 1, 100);
        System.out.println("Вы ввели" + number);
    }
}
