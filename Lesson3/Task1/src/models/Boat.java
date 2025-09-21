package models;

import enums.TransportType;
import interfaces.EnginePowered;
import interfaces.FuelConsumable;
import interfaces.Movable;

public class Boat extends Transport implements EnginePowered, FuelConsumable, Movable {
    private Engine engine;
    private double fuelLevel;
    private boolean isEngineRunning;
    private double currentSpeed;
    private double displacement; // водоизмещение
    
    public Boat(String model, int year, int capacity, Engine engine, 
                double initialFuel, double displacement) {
        super(model, year, capacity, TransportType.BOAT);
        this.engine = engine;
        this.fuelLevel = initialFuel;
        this.isEngineRunning = false;
        this.currentSpeed = 0;
        this.displacement = displacement;
    }
    
    @Override
    public void start() {
        startEngine();
    }
    
    @Override
    public void stop() {
        stopEngine();
    }
    
    @Override
    public String getInfo() {
        return String.format("Катер: %s (%d г.), %d мест, водоизмещение: %.1f т, %s, топливо: %.1f л",
                model, year, capacity, displacement, engine, fuelLevel);
    }
    
    // EnginePowered implementation
    @Override
    public Engine getEngine() {
        return engine;
    }
    
    @Override
    public void startEngine() {
        if (fuelLevel > 0) {
            isEngineRunning = true;
            System.out.println(model + ": Двигатель запущен (Буль-буль!)");
        } else {
            System.out.println(model + ": Нет топлива для запуска");
        }
    }
    
    @Override
    public void stopEngine() {
        isEngineRunning = false;
        currentSpeed = 0;
        System.out.println(model + ": Двигатель остановлен");
    }
    
    @Override
    public boolean isEngineRunning() {
        return isEngineRunning;
    }
    
    // FuelConsumable implementation
    @Override
    public double getFuelConsumption() {
        return 15.0; // катер расходует больше
    }
    
    @Override
    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println(model + ": Заправлено " + amount + " л. Всего: " + fuelLevel + " л");
    }
    
    @Override
    public double getFuelLevel() {
        return fuelLevel;
    }
    
    // Movable implementation
    @Override
    public void move() {
        if (isEngineRunning) {
            currentSpeed = 40;
            System.out.println(model + ": Плывем со скоростью " + currentSpeed + " узлов");
        } else {
            System.out.println(model + ": Сначала запустите двигатель!");
        }
    }
    
    @Override
    public void stopMoving() {
        currentSpeed = 0;
        System.out.println(model + ": Остановились");
    }
    
    @Override
    public double getCurrentSpeed() {
        return currentSpeed;
    }
    
    // Специфичный метод катера
    public void dropAnchor() {
        System.out.println(model + ": Якорь брошен!");
    }
    
    public double getDisplacement() {
        return displacement;
    }
}