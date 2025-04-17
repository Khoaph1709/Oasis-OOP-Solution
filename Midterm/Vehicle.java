abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int year;

    public Vehicle() {
        brand = null;
        model = null;
        year = 0;
    }

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year; 
    }

    public void setYear(int year) {
        this.year = year; 
    }

    public abstract double calculateValue();

    public abstract String getInfo();

    public boolean equals(Vehicle other) {
        if (other instanceof Vehicle) {
            Vehicle otherVehicle = (Vehicle) other;
            return brand.equals(otherVehicle.brand) && model.equals(otherVehicle.model) && year == otherVehicle.year;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Vehicle[brand=" + brand + ",model=" + model + ",year=" + year + "]";
    }
}