public class Rectangle extends Shape {
    protected Point topLeft;
    protected double width;
    protected double length;

    public Rectangle() {
        topLeft = new Point(0,0);
        width = 1.0;
        length = 1.0;
    }

    public Rectangle(double width, double length) {
        topLeft = new Point(0,0);
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        topLeft = new Point(0,0);
        this.width = width;
        this.length = length;
    }

    public Rectangle(Point topLeft, double width, double length, String color, boolean filled) {
        super(color, filled);
        this.topLeft = topLeft;
        this.width = width;
        this.length = length;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rectangle) {
            Rectangle r = (Rectangle) obj;
            double epsilon = 0.001;
            if (Math.abs(width - r.width) < epsilon && Math.abs(length - r.length) < epsilon && topLeft.equals(r.topLeft)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "Rectangle[topLeft=" + topLeft + ",width=" + width + ",length=" + length + ",color=" + color + ",filled=" + filled + "]";
    }
}
