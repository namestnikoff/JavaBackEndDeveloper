package enums;

public enum EngineType {
    INTERNAL_COMBUSTION("Двигатель внутреннего сгорания"),
    ELECTRIC_MOTOR("Электродвигатель"),
    NONE("Нет двигателя");
    
    private final String name;
    
    private EngineType(String rusname) {
        this.name = rusname;
    }
    
    @Override
    public String toString() {
        return name;
    }
}