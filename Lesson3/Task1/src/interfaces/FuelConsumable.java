package interfaces;

public interface FuelConsumable {
    double getFuelConsumption();
    void refuel(double amount);
    double getFuelLevel();
}
