public class Point {
    private double pointX;
    private double pointY;

    public Point(double x, double y) {
        pointX = x;
        pointY = y;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public double distance(Point point) {
        double x = point.getPointX() - this.pointX;
        double y = point.getPointY() - this.pointY;
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point point = (Point) obj;
            return point.getPointX() == this.pointX && point.getPointY() == this.pointY;
        } 
        return false;
    }
}
