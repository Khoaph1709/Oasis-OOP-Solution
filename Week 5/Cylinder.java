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

    public static void main(String[] args) {
        Cylinder c1 = new Cylinder();
        Cylinder c2 = new Cylinder(5.0, 2.0);
        System.out.println(c1);
        System.out.println(c2);

        c1.setHeight(4.0);
        System.out.println(c1.getArea());
    }
    
}
