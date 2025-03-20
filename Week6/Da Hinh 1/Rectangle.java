public class Rectangle extends Shape {
    protected  double width;
    protected  double length;

    /**
     * Constructs a new Rectangle object with default width and length values of 1.
     * The Rectangle inherits properties from the Shape class.
     * By default, the color is null and the shape is not filled as initialized in the parent class.
     */
    public Rectangle() {
        super();
        this.width = 1;
        this.length = 1;
    }

    /**
     * Constructs a new Rectangle object with the specified width and length.
     *
     * @param width the width of the rectangle
     * @param length the length of the rectangle
     */
    public Rectangle(double width, double length) {
        super();
        this.width = width;
        this.length = length;
    }

    /**
     * Constructs a new Rectangle object with the specified width, length, color, and filled status.
     *
     * @param width the width of the rectangle
     * @param length the length of the rectangle
     * @param color the color of the rectangle
     * @param filled the filled status of the rectangle
     */
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return this.length;
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
    public String toString() {
        return "Rectangle[width="
                + this.width + ",length="
                + this.length + ",color="
                + this.color + ",filled="
                + this.filled + "]";
    }
}
