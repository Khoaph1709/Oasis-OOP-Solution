import java.util.ArrayList;
import java.util.List;

public class Garage {
    private List<Vehicle> vehicles;

    public Garage() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public List<Vehicle> getVehiclesByBrand(String brand) {
        List<Vehicle> brandVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getBrand().equals(brand)) {
                brandVehicles.add(vehicle);
            }
        }
        return brandVehicles;
    }

    public double getTotalValue() {
        double totalValue = 0;
        for (Vehicle vehicle : vehicles) {
            totalValue += vehicle.calculateValue();
        }
        return totalValue;
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Garage Inventory:\n");
        for (Vehicle vehicle : vehicles) {
            info.append(vehicle.getInfo()).append("\n");
        }
        return info.toString();
    }
}
