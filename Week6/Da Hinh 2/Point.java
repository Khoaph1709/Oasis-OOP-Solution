

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

    public void setPointX(double x) {
        pointX = x;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double y) {
        pointY = y;
    }
    public double distance(Point p) {
        return Math.sqrt((pointX - p.pointX) * (pointX - p.pointX) + (pointY - p.pointY) * (pointY - p.pointY));
    }

    @Override
    public boolean equals(Object p) {
        if (p instanceof Point) {
            double epsilon = 0.001;
            Point point = (Point) p;
            if (Math.abs(pointX - point.pointX) < epsilon && Math.abs(pointY - point.pointY) < epsilon)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("(%.1f,%.1f)", pointX, pointY);
    }
}