public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, String model, 
    String registrationNumber, Person owner, int numberOfDoors) {
        super(brand, model, registrationNumber, owner);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car:").append("\n").append("\t");
        sb.append("Brand: ").append(getBrand()).append("\n").append("\t");
        sb.append("Model: ").append(getModel()).append("\n").append("\t");
        sb.append("Registration Number: ")
        .append(getRegistrationNumber()).append("\n").append("\t");
        sb.append("Number of Doors: ").append(numberOfDoors).append("\n").append("\t");
        sb.append("Belongs to ").append(super.getOwner().getInfo()).append("\n");
        
        return sb.toString();
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
