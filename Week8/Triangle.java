public class Triangle implements GeometricObject{
    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(Point p1, Point p2, Point p3) throws RuntimeException  {
        if (p1.equals(p2) || p1.equals(p3) || p2.equals(p3)) {
            throw new RuntimeException("Two points cannot be the same");
        }

        point1 = p1;
        point2 = p2;
        point3 = p3;

        if (this.getArea() == 0) {
            throw new RuntimeException("Three points cannot form a triangle");
        }
    }

    public Point getP1() {
        return point1;
    }

    public void setP1(Point p1) {
        point1 = p1;
    }

    public Point getP2() {
        return point2;
    }

    public void setP2(Point p2) {
        point2 = p2;
    }

    public Point getP3() {
        return point3;
    }

    public void setP3(Point p3) {
        point3 = p3;
    }

    @Override
    public double getArea() {
        double a = point1.distance(point2);
        double b = point2.distance(point3);
        double c = point3.distance(point1);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        double a = point1.distance(point2);
        double b = point2.distance(point3);
        double c = point3.distance(point1);
        return a + b + c;
    }

    @Override
    public String getInfo() {
        return String.format("Triangle[(%.2f,%.2f),(%.2f,%.2f),(%.2f,%.2f)]", point1.getPointX(), point1.getPointY(), point2.getPointX(), point2.getPointY(), point3.getPointX(), point3.getPointY());
    }
}
