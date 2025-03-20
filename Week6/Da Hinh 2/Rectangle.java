public class Rectangle extends Shape {
    protected Point topLeft;
    protected double width;
    protected double length;

    /**
     * Creates a default instance of the Rectangle class.
     * The rectangle is*/
    public Rectangle() {
        topLeft = new Point(0, 0);
        width = 1.0;
        length = 1.0;
    }

    /**
     * Constructs a Rectangle object with the specified width and length.
     * The top-left corner of the rectangle is initialized to point (0, 0).
     *
     * @param width the width of the rectangle
     * @param length the length of the rectangle
     */
    public Rectangle(double width, double length) {
        topLeft = new Point(0, 0);
        this.width = width;
        this.length = length;
    }

    /**
     * Constructs a Rectangle object with specified width, length, color, and filled attributes.
     *
     * @param width the width of the rectangle
     * @param length the length of the rectangle
     * @param color the color of the rectangle
     * @param filled the filled status of the rectangle; true if filled, false otherwise
     */
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        topLeft = new Point(0, 0);
        this.width = width;
        this.length = length;
    }

    /**
     * Constructs a Rectangle object with the specified top-left corner, width, length, color,
     * and filled status.
     *
     * @param topLeft the top-left corner of the rectangle as a Point object
     * @param width the width of the rectangle
     * @param length the length of the rectangle
     * @param color the color of the rectangle
     * @param filled the filled status of the rectangle; true if filled, false otherwise
     */
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
            if (Math.abs(width - r.width) < epsilon
                    && Math.abs(length - r.length) < epsilon
                    && topLeft.equals(r.topLeft)) {
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
        return "Rectangle[topLeft=" + topLeft
                + ",width=" + width
                + ",length=" + length
                + ",color=" + color
                + ",filled=" + filled + "]";
    }
}
