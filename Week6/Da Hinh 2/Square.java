public class Square extends Rectangle {
    public Square() {
        super();
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public Square(Point topLeft, double side, String color, boolean filled) {
        super(topLeft, side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Square) {
            Square s = (Square) obj;
            double epsilon = 0.001;
            if (Math.abs(getSide() - s.getSide()) < epsilon && getTopLeft().equals(s.getTopLeft())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Square[topLeft=" + getTopLeft() + ",side=" + getSide() + ",color=" + getColor() + ",filled=" + isFilled() + "]";
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
