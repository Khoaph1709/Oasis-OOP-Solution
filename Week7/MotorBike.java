public class MotorBike extends Vehicle {
    private boolean hasSidecar;

    public MotorBike(String brand, String model, String registrationNumber, Person owner, boolean hasSidecar) {
        super(brand, model, registrationNumber, owner);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("MotorBike:").append("\n").append("\t");
        sb.append("Brand: ").append(getBrand()).append("\n").append("\t");
        sb.append("Model: ").append(getModel()).append("\n").append("\t");
        sb.append("Registration Number: ").append(getRegistrationNumber()).append("\n").append("\t");
        sb.append("Has Sidecar: ").append(hasSidecar).append("\n").append("\t");
        sb.append("Belongs to ").append(super.getOwner().getInfo()).append("\n");

        return sb.toString();
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }
}
