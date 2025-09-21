package test;

import enums.EngineType;
import enums.FuelType;
import models.Engine;

public class SimpleTest {
    public static void main(String[] args) {
        // Тестируем класс Engine
        Engine carEngine = new Engine(EngineType.INTERNAL_COMBUSTION, 150, FuelType.GASOLINE);
        System.out.println("Двигатель: " + carEngine);
        
        Engine electricEngine = new Engine(EngineType.ELECTRIC_MOTOR, 200, FuelType.ELECTRIC);
        System.out.println("Электродвигатель: " + electricEngine);
        
        // Тестируем перечисления
        System.out.println("\nДоступные типы топлива:");
        for (FuelType fuel : FuelType.values()) {
            System.out.println("- " + fuel);
        }
        
        System.out.println("\nДоступные типы двигателей:");
        for (EngineType engine : EngineType.values()) {
            System.out.println("- " + engine);
        }
    }
}