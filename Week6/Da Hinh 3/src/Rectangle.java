import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Shape {
    public Rectangle(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fill(new Rectangle2D.Double(x, y, width, height));
    }

    public static Rectangle createRandom(int panelWidth, int panelHeight) {
        double width = random.nextDouble() * 40 + 30; // Random width between 30 and 70
        double height = random.nextDouble() * 40 + 30; // Random height between 30 and 70
        double x = random.nextDouble() * (panelWidth - width);
        double y = random.nextDouble() * (panelHeight - height);
        return new Rectangle(x, y, width, height);
    }
}