package enums;

public enum FuelType {
    GASOLINE("Бензин"),
    DIESEL("Дизель"),
    ELECTRIC("Электричество"),
    NONE("Нет топлива");
    
    private final String name;
    
    FuelType(String rusname) {
        this.name = rusname;
    }
    
    @Override
    public String toString() {
        return name;
    }
}