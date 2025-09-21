package models;

import enums.TransportType;
import interfaces.Movable;

public class Horse extends Transport implements Movable {
    private String breed;
    private int age;
    private double currentSpeed;
    
    public Horse(String model, int year, int capacity, String breed, int age) {
        super(model, year, capacity, TransportType.HORSE);
        this.breed = breed;
        this.age = age;
        this.currentSpeed = 0;
    }
    
    @Override
    public void start() {
        System.out.println(model + ": Поскакали!");
    }
    
    @Override
    public void stop() {
        currentSpeed = 0;
        System.out.println(model + ": Остановились");
    }
    
    @Override
    public String getInfo() {
        return String.format("Лошадь: %s (%s, %d лет), %d г.р., вмещает %d всадника",
                model, breed, age, year, capacity);
    }
    
    // Реализация Movable
    @Override
    public void move() {
        currentSpeed = 30;
        System.out.println(model + ": Скачем со скоростью " + currentSpeed + " км/ч");
    }
    
    @Override
    public void stopMoving() {
        currentSpeed = 0;
        System.out.println(model + ": Перестали скакать");
    }
    
    @Override
    public double getCurrentSpeed() {
        return currentSpeed;
    }
    
    // Специфичные методы лошади
    public void neigh() {
        System.out.println(model + ": И-го-го!");
    }
    
    public void feed() {
        System.out.println(model + ": Кушаем овес");
    }
    
    // Геттеры
    public String getBreed() {
        return breed;
    }
    
    public int getAge() {
        return age;
    }
}