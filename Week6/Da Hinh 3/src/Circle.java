import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Shape {
    public Circle(double x, double y, double radius) {
        super(x, y, radius * 2, radius * 2);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fill(new Ellipse2D.Double(x, y, width, height));
    }

    @Override
    public boolean intersects(Shape other) {
        double centerX1 = x + width / 2;
        double centerY1 = y + height / 2;
        double radius1 = width / 2;

        if (other instanceof Circle) {
            Circle otherCircle = (Circle) other;
            double centerX2 = otherCircle.x + otherCircle.width / 2;
            double centerY2 = otherCircle.y + otherCircle.height / 2;
            double radius2 = otherCircle.width / 2;

            double distance = Math.sqrt(
                Math.pow(centerX2 - centerX1, 2) +
                Math.pow(centerY2 - centerY1, 2)
            );

            return distance < (radius1 + radius2);
        }

        return super.intersects(other);
    }

    public static Circle createRandom(int panelWidth, int panelHeight) {
        double radius = random.nextDouble() * 30 + 20; // Random radius between 20 and 50
        double x = random.nextDouble() * (panelWidth - radius * 2);
        double y = random.nextDouble() * (panelHeight - radius * 2);
        return new Circle(x, y, radius);
    }
}