package main;

import enums.EngineType;
import enums.FuelType;
import models.*;
import interfaces.Movable;
import utils.InputHandler;
import java.util.Scanner;

public class TransportManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== СИСТЕМА УПРАВЛЕНИЯ ТРАНСПОРТОМ ===\n");
        
        // Создаем несколько видов транспорта
        Engine carEngine = new Engine(EngineType.INTERNAL_COMBUSTION, 120, FuelType.GASOLINE);
        Engine bikeEngine = new Engine(EngineType.INTERNAL_COMBUSTION, 80, FuelType.GASOLINE);
        Engine boatEngine = new Engine(EngineType.INTERNAL_COMBUSTION, 200, FuelType.DIESEL);
        
        Transport[] transports = {
            new Car("Toyota Corolla", 2020, 5, carEngine, 40.0),
            new Motorcycle("Harley Davidson", 2019, 2, bikeEngine, 20.0, false),
            new Boat("Sea Ray", 2021, 8, boatEngine, 100.0, 3.5),
            new Horse("Буцефал", 2015, 1, "Арабская", 9)
        };
        
        boolean running = true;
        
        while (running) {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1. Показать весь транспорт");
            System.out.println("2. Управлять транспортом");
            System.out.println("3. Выход");
            
            int choice = InputHandler.getInt(scanner, "Выберите действие: ", 1, 3);
            
            switch (choice) {
                case 1:
                    showAllTransports(transports);
                    break;
                case 2:
                    manageTransport(scanner, transports);
                    break;
                case 3:
                    running = false;
                    System.out.println("До свидания!");
                    break;
            }
        }
        
        scanner.close();
    }
    
    private static void showAllTransports(Transport[] transports) {
        System.out.println("\n=== ВЕСЬ ТРАНСПОРТ ===");
        for (int i = 0; i < transports.length; i++) {
            System.out.println((i + 1) + ". " + transports[i].getInfo());
        }
    }
    
    private static void manageTransport(Scanner scanner, Transport[] transports) {
        showAllTransports(transports);
        int choice = InputHandler.getInt(scanner, "Выберите транспорт: ", 1, transports.length);
        
        Transport selected = transports[choice - 1];
        
        System.out.println("\nВыбран: " + selected.getInfo());
        
        boolean managing = true;
        while (managing) {
            System.out.println("\n--- Управление " + selected.getModel() + " ---");
            System.out.println("1. Запустить");
            System.out.println("2. Остановить");
            System.out.println("3. Двигаться");
            System.out.println("4. Информация");
            System.out.println("5. Специальные действия");
            System.out.println("6. Назад в меню");
            
            int action = InputHandler.getInt(scanner, "Выберите действие: ", 1, 6);
            
            switch (action) {
                case 1:
                    selected.start();
                    break;
                case 2:
                    selected.stop();
                    break;
                case 3:
                    if (selected instanceof Movable) {
                        ((Movable) selected).move();
                    } else {
                        System.out.println("Этот транспорт не может двигаться");
                    }
                    break;
                case 4:
                    selected.displayInfo();
                    break;
                case 5:
                    performSpecialAction(selected);
                    break;
                case 6:
                    managing = false;
                    break;
            }
        }
    }
    
    private static void performSpecialAction(Transport transport) {
        if (transport instanceof Car) {
            ((Car) transport).honk();
        } else if (transport instanceof Motorcycle) {
            ((Motorcycle) transport).performTrick();
        } else if (transport instanceof Boat) {
            ((Boat) transport).dropAnchor();
        } else if (transport instanceof Horse) {
            ((Horse) transport).neigh();
        } else {
            System.out.println("Нет специальных действий для этого транспорта");
        }
    }
}