
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String address;
    private final List<Vehicle> vehicleList;

    /**
     * .
     */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
        this.vehicleList = new ArrayList<>();
    }

    /**
     * .
     */
    public void addVehicle(Vehicle vehicle) {
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).equals(vehicle)) {
                return;
            }
        }
        vehicleList.add(vehicle);
    }

    /**
     * .
     */
    public void removeVehicle(String registrationNumber) {
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getRegistrationNumber().equals(registrationNumber)) {
                vehicleList.remove(i);
                break;
            }
        }
    }

    /**
     * .
     */
    public String getVehiclesInfo() {
        StringBuilder sb = new StringBuilder();
        if (vehicleList.isEmpty()) {
            sb.append(name);
            sb.append(" has no vehicle!");
            return sb.toString();        
        } else {
            sb.append(name);
            sb.append(" has:").append("\n").append("\n");
            for (Vehicle vehicle : vehicleList) {
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
