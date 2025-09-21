package models;

import enums.TransportType;
import interfaces.EnginePowered;
import interfaces.FuelConsumable;
import interfaces.Movable;

public class Motorcycle extends Transport implements EnginePowered, FuelConsumable, Movable {
    private Engine engine;
    private double fuelLevel;
    private boolean isEngineRunning;
    private double currentSpeed;
    private boolean hasSidecar;
    
    public Motorcycle(String model, int year, int capacity, Engine engine, 
                     double initialFuel, boolean hasSidecar) {
        super(model, year, capacity, TransportType.MOTORCYCLE);
        this.engine = engine;
        this.fuelLevel = initialFuel;
        this.isEngineRunning = false;
        this.currentSpeed = 0;
        this.hasSidecar = hasSidecar;
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
        String sidecarInfo = hasSidecar ? "с коляской" : "без коляски";
        return String.format("Мотоцикл: %s (%d г.), %d мест (%s), %s, топливо: %.1f л",
                model, year, capacity, sidecarInfo, engine, fuelLevel);
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
            System.out.println(model + ": Двигатель запущен (Врум-врум!)");
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
        return 5.0; // мотоцикл экономичнее
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
            currentSpeed = 80;
            System.out.println(model + ": Едем со скоростью " + currentSpeed + " км/ч (Ветер в лицо!)");
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
    
    // Специфичный метод мотоцикла
    public void performTrick() {
        System.out.println(model + ": Показываем трюк!");
}
    
    public boolean hasSidecar() {
        return hasSidecar;
    }
}