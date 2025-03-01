
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String address;
    private final List<Vehicle> vehicles;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(String registrationNumber) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getRegistrationNumber().equals(registrationNumber)) {
                vehicles.remove(i);
                break;
            }
        }
    }

    public String getVehicleInfo() {
        StringBuilder sb = new StringBuilder();
        if (vehicles.isEmpty()) {
            sb.append(name);
            sb.append(" has no vehicles!");
            return sb.toString();        
        } else {
            sb.append(name);
            sb.append(" has:").append("\n").append("\n");
            for (Vehicle vehicle : vehicles) {
                sb.append(vehicle.getInfo());
            }
            return sb.toString();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfo() {
        return name + " - " + address;
    }
}
