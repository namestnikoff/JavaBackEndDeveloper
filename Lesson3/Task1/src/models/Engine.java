package models;

import enums.EngineType;
import enums.FuelType;

public class Engine {
    private EngineType type;
    private int power;
    private FuelType fuelType;
    
    public Engine(EngineType type, int power, FuelType fuelType) {
        this.type = type;
        this.power = power;
        this.fuelType = fuelType;
    }
    
    // Геттеры
    public EngineType getType() {
        return type;
    }
    
    public int getPower() {
        return power;
    }
    
    public FuelType getFuelType() {
        return fuelType;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%d л.с.), топливо: %s", type, power, fuelType);
    }
}