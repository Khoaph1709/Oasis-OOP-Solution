public class Car extends Vehicle {
    protected int seats;

    public Car() {
        super();
        seats = 0;
    }

    public Car(String brand, String model, int year, int seats) {
        super(brand, model, year);
        this.seats = seats;
    }

    @Override
    public String getInfo() {
        return "Car(" + brand + " " + model + " " + year + ")" + " - " + seats + " seats";
    }

    @Override
    public double calculateValue() {
        int age = 2025 - year;
        double baseValue = 0;
        if (age < 3) {
            baseValue = 50000;
        } else if (age >= 3 && age <= 7) {
            baseValue = 30000;
        } else {
            baseValue = 15000;
        }
        return baseValue + (seats * 1000);
    }

    public String toString() {
        return "Car[brand=" + brand + ",model=" + model + ",year=" + year + ",seats=" + seats + "]";
        // Output: "Car[brand=Honda,model=Civic,year=2000,seats=5"]
    }

    
    public boolean equals(Vehicle other) {
        if (!(other instanceof Car)) {
            return false; 
        }
        Car otherCar = (Car) other;
        return super.equals(otherCar) && seats == otherCar.seats;
    }
}
