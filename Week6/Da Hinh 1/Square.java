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

    public double getSide() {
        return super.getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setWidth(double size) {
        super.setWidth(size);
        super.setLength(size);
    }

    @Override
    public void setLength(double size) {
        super.setWidth(size);
        super.setLength(size);
    }

    @Override
    public String toString() {
        return "Square[side=" + super.getWidth() + ",color=" + super.getColor() + ",filled=" + super.isFilled() + "]";
    }
}
