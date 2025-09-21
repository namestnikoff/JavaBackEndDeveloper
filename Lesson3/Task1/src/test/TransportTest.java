package test;

import enums.EngineType;
import enums.FuelType;
import models.Car;
import models.Motorcycle;
import models.Boat;
import models.Engine;

public class TransportTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ ТРАНСПОРТА ===\n");
        
        // Создаем двигатели
        Engine carEngine = new Engine(EngineType.INTERNAL_COMBUSTION, 120, FuelType.GASOLINE);
        Engine bikeEngine = new Engine(EngineType.INTERNAL_COMBUSTION, 80, FuelType.GASOLINE);
        Engine boatEngine = new Engine(EngineType.INTERNAL_COMBUSTION, 200, FuelType.DIESEL);
        
        // Создаем транспорт
        Car car = new Car("Toyota Corolla", 2020, 5, carEngine, 40.0);
        Motorcycle bike = new Motorcycle("Harley Davidson", 2019, 2, bikeEngine, 20.0, false);
        Boat boat = new Boat("Sea Ray", 2021, 8, boatEngine, 100.0, 3.5);
        
        // Тестируем автомобиль
        System.out.println("=== АВТОМОБИЛЬ ===");
        car.displayInfo();
        car.start();
        car.move();
        car.honk();
        car.stop();
        System.out.println();
        
        // Тестируем мотоцикл
        System.out.println("=== МОТОЦИКЛ ===");
        bike.displayInfo();
        bike.start();
        bike.move();
        bike.performTrick();
        bike.stop();
        System.out.println();
        
        // Тестируем катер
        System.out.println("=== КАТЕР ===");
        boat.displayInfo();
        boat.start();
        boat.move();
        boat.dropAnchor();
        boat.stop();
    }
}