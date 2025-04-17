public class Motorcycle extends Vehicle {
    protected int engineSize;

    public Motorcycle() {
        super();
        engineSize = 0;
    }

    public Motorcycle(String brand, String model, int year, int engineSize) {
        super(brand, model, year);
        this.engineSize = engineSize;
    }

    @Override
    public String getInfo() {
        return "Motorcycle(" + brand + " " + model + " " + year + ")" + " - " + engineSize + "cc";
    }

    @Override
    public double calculateValue() {
        double baseValue = 0;
        int age = 2025 - year;
        if (age < 3) {
            baseValue = 20000;
        } else if (age >= 3 && age <= 7) {
            baseValue = 10000;
        } else {
            baseValue = 5000;
        }
        return baseValue + (engineSize * 10);
    }

    @Override
    public boolean equals(Vehicle other) {
        if (!(other instanceof Motorcycle)) {
            return false;
        }
        Motorcycle otherMotorcycle = (Motorcycle) other;
        return super.equals(otherMotorcycle) && engineSize == otherMotorcycle.engineSize;
    }
}
