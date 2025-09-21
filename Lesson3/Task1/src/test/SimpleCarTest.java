package test;

import enums.EngineType;
import enums.FuelType;
import models.Car;
import models.Engine;

public class SimpleCarTest {
    public static void main(String[] args) {
        // Создаем двигатель
        Engine engine = new Engine(EngineType.INTERNAL_COMBUSTION, 120, FuelType.GASOLINE);
        
        // Создаем автомобиль
        Car car = new Car("Toyota Corolla", 2020, 5, engine, 40.0);
        
        // Тестируем методы
        car.displayInfo();
        car.start();
        car.move();
        car.honk();
        car.refuel(20.0);
        car.stop();
        
        System.out.println("Текущая скорость: " + car.getCurrentSpeed() + " км/ч");
        System.out.println("Уровень топлива: " + car.getFuelLevel() + " л");
    }
}