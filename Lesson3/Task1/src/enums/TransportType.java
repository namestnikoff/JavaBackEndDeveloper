package enums;

public enum TransportType {
    CAR("Автомобиль"),
    MOTORCYCLE("Мотоцикл"),
    BOAT("Катер"),
    HORSE("Лошадь");
    
    private final String name;
    
    private TransportType(String rusname) {
        this.name = rusname;
    }
    
    @Override
    public String toString() {
        return name;
    }
}