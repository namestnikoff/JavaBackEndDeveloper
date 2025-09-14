//класс immutable - наследование запрещено
public final class Vector {
    //наследование атрибутов тоже запрещено и нет сеттеров для изменения атрибутов
    private final double x;
    private final double y;
    private final double z;
    

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    // метод вычисляющий длину вектора
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", x, y, z);
    }
}