package models;

import enums.TransportType;
import interfaces.EnginePowered;
import interfaces.FuelConsumable;

public abstract class Transport {
    protected String model;
    protected int year;
    protected int capacity;
    protected TransportType transportType;
    
    public Transport(String model, int year, int capacity, TransportType transportType) {
        this.model = model;
        this.year = year;
        this.capacity = capacity;
        this.transportType = transportType;
    }
    
    // Абстрактные методы
    public abstract void start();
    public abstract void stop();
    public abstract String getInfo();
    
    // Общие методы
    public void displayInfo() {
        System.out.println(getInfo());
    }
    
    // Геттеры
    public String getModel() {
        return model;
    }
    
    public int getYear() {
        return year;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public TransportType getTransportType() {
        return transportType;
    }
}