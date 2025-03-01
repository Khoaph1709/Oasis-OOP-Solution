public class VehicleTest {
    public static void main(String[] args) {
        // Create persons
        Person person1 = new Person("John Doe", "123 Main St");

        // Create vehicles
        Car car1 = new Car("TOYOTA", "Corolla", "ABC123", person1, 4);
        Car car2 = new Car("HONDA", "Civic", "XYZ789", person1, 4);
        MotorBike bike2 = new MotorBike("YAMAHA", "YZF-R1", "DEF456", person1, true);
        MotorBike bike1 = new MotorBike("HONDA", "NMAX", "GHI123", person1, false);

        // Test adding vehicles to persons
        person1.addVehicle(car1);
        person1.addVehicle(bike1);
        person1.addVehicle(car2);
        person1.addVehicle(bike2);

        // Test getInfo methods
        System.out.println("Testing Person and Vehicle Info:");
        System.out.println("Person 1 Info: " + person1.getInfo());
        System.out.println("\nPerson 1 Vehicles:");
        System.out.println(person1.getVehicleInfo());

        // Test transferring ownership
        Person person2 = new Person("Jane Smith", "456 Oak St");
        car1.transferOwnership(person2);
        bike1.transferOwnership(person2);
        // Test getInfo methods after transferring ownership
        System.out.println("\nTesting Person and Vehicle Info after transferring ownership:");

        System.out.println(person1.getVehicleInfo());
        System.out.println(person2.getVehicleInfo());
    }
}
