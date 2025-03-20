public class Circle extends Shape {
    protected Point center;
    protected double radius;

    public Circle() {
        center = new Point(0.0, 0.0);
        radius = 1.0;
    }

    public Circle(double radius) {
        this();
        this.radius = radius;
    }

    /**
     * Constructs a Circle object with the specified radius, color, and filled status.
     *
     * @param radius the radius of the circle
     * @param color the color of the circle
     * @param filled the filled status of the circle; true if filled, false otherwise
     */
    public Circle(double radius, String color, boolean filled) {
        this(radius);
        this.color = color;
        this.filled = filled;
    }

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    /**
     * Constructs a Circle object with the specified center, radius, color, and filled status.
     *
     * @param center the center point of the circle
     * @param radius the radius of the circle
     * @param color the color of the circle
     * @param filled the filled status of the circle; true if filled, false otherwise
     */
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
        return "Circle[center=" + center
                + ",radius=" + radius
                + ",color=" + color
                + ",filled=" + filled + "]";
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
}
