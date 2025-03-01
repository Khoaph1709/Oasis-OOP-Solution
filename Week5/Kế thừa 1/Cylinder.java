public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        super();
        height = 1.0;
    }

    public Cylinder(double r) {
        super(r);
        height = 1.0;
    }

    public Cylinder(double r, double h) {
        super(r);
        height = h;
    }

    public Cylinder(double r, double h, String c) {
        super(r, c);
        height = h;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double h) {
        height = h;
    }

    public double getVolume() {
        return super.getArea() * height;
    }

    @Override
    public double getArea() {
        return 2 * PI * getRadius() * height + 2 * super.getArea();
    }

    @Override
    public String toString() {
        return "Cylinder[" + super.toString() + ",height=" + height + "]";
    }
}
