package models;

import enums.TransportType;
import interfaces.EnginePowered;
import interfaces.FuelConsumable;
import interfaces.Movable;

public class Car extends Transport implements EnginePowered, FuelConsumable, Movable {
    private Engine engine;
    private double fuelLevel;
    private boolean isEngineRunning;
    private double currentSpeed;
    
    public Car(String model, int year, int capacity, Engine engine, double initialFuel) {
        super(model, year, capacity, TransportType.CAR);
        this.engine = engine;
        this.fuelLevel = initialFuel;
        this.isEngineRunning = false;
        this.currentSpeed = 0;
    }
    
    // Реализация методов Transport
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
        return String.format("Автомобиль: %s (%d г.), %d мест, %s, топливо: %.1f л",
                model, year, capacity, engine, fuelLevel);
    }
    
    // Реализация EnginePowered
    @Override
    public Engine getEngine() {
        return engine;
    }
    
    @Override
    public void startEngine() {
        if (fuelLevel > 0) {
            isEngineRunning = true;
            System.out.println(model + ": Двигатель запущен");
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
    
    // Реализация FuelConsumable
    @Override
    public double getFuelConsumption() {
        return 10.0; // фиксированный расход
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
    
    // Реализация Movable
    @Override
    public void move() {
        if (isEngineRunning) {
            currentSpeed = 60;
            System.out.println(model + ": Едем со скоростью " + currentSpeed + " км/ч");
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
    
    // Простой метод автомобиля
    public void honk() {
        System.out.println(model + ": Би-бип!");
    }
}