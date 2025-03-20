public class Triangle implements GeometricObject {
    private Point p1;
    private Point p2;
    private Point p3;

    /**
     * .
     */
    public Triangle(Point p1, Point p2, Point p3) throws RuntimeException  {
        if (p1.equals(p2) || p1.equals(p3) || p2.equals(p3)) {
            throw new RuntimeException("Two points cannot be the same");
        }

        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        
        if (this.getArea() == 0) {
            throw new RuntimeException("Three points cannot form a triangle");
        }
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    @Override
    public double getArea() {
        double a = p1.distance(p2);
        double b = p2.distance(p3);
        double c = p3.distance(p1);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        double a = p1.distance(p2);
        double b = p2.distance(p3);
        double c = p3.distance(p1);
        return a + b + c;
    }

    @Override
    public String getInfo() {
        return String.format("Triangle[(%.2f,%.2f),(%.2f,%.2f),(%.2f,%.2f)]", 
        p1.getPointX(), p1.getPointY(), 
        p2.getPointX(), p2.getPointY(), 
        p3.getPointX(), p3.getPointY());
    }
}
