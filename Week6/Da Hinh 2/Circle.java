public class Circle extends Shape {
    protected Point center;
    protected double radius;

    public Circle() {
        center = new Point(0.0, 0.0);
        radius = 1.0;
    }

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Circle(Point center, double radius, String color, boolean filled) {
        super(color, filled);
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle[center=" + center + ",radius=" + radius + ",color=" + color + ",filled=" + filled + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circle) {
            Circle c = (Circle) obj;
            double epsilon = 0.001;
            if (Math.abs(radius - c.radius) < epsilon && center.equals(c.center)) {
                return true;   
            }
        }
        return false;
    }   

    @Override
    public int hashCode() {
        return center.hashCode() + Double.hashCode(radius);
    }

    public static void main(String[] args) {
        // Test constructors
        Circle c1 = new Circle();
        Circle c2 = new Circle(new Point(2.0, 2.0), 3.0);
        Circle c3 = new Circle(new Point(1.0, 1.0), 2.0, "red", true);

        // Test getters and setters
        System.out.println("Initial center of c1: " + c1.getCenter());
        System.out.println("Initial radius of c1: " + c1.getRadius());
        
        c1.setCenter(new Point(3.0, 3.0));
        c1.setRadius(4.0);
        System.out.println("After setting, center of c1: " + c1.getCenter());
        System.out.println("After setting, radius of c1: " + c1.getRadius());

        // Test area and perimeter
        System.out.println("Area of c2: " + String.format("%.2f", c2.getArea()));
        System.out.println("Perimeter of c2: " + String.format("%.2f", c2.getPerimeter()));

        // Test toString
        System.out.println("c3 toString: " + c3.toString());

        // Test equals and hashCode
        Circle c4 = new Circle(new Point(2.0, 2.0), 3.0);
        System.out.println("c2 equals c4: " + c2.equals(c4));
        System.out.println("c2 hashCode: " + c2.hashCode());
        System.out.println("c4 hashCode: " + c4.hashCode());

        Circle c5 = new Circle(new Point(2.0, 2.1), 3.0);
        System.out.println("c2 equals c5: " + c2.equals(c5));
    }
}
