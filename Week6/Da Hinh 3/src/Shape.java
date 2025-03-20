import java.awt.*;
import java.util.Random;

public abstract class Shape {
    protected double x;
    protected double y;
    protected double width;
    protected double height;
    protected Color color;
    protected double velocityX;
    protected double velocityY;
    protected static final Random random = new Random();

    public Shape(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        this.velocityX = random.nextDouble() * 4 - 2; // Random velocity between -2 and 2
        this.velocityY = random.nextDouble() * 4 - 2;
    }

    public abstract void draw(Graphics2D g2d);

    public void move() {
        x += velocityX;
        y += velocityY;
    }

    public void handleCollision(Shape other) {
        // Create two smaller shapes
        double newWidth = width / 2;
        double newHeight = height / 2;
        
        // Create first split shape
        Shape split1 = createSplitShape(x - newWidth/2, y - newHeight/2, newWidth, newHeight);
        // Create second split shape
        Shape split2 = createSplitShape(x + width/2, y + height/2, newWidth, newHeight);
        
        // Add the new shapes to the layer
        if (this instanceof Circle) {
            Layer.addShape(new Circle(split1.x, split1.y, split1.width/2));
            Layer.addShape(new Circle(split2.x, split2.y, split2.width/2));
        } else {
            Layer.addShape(new Rectangle(split1.x, split1.y, split1.width, split1.height));
            Layer.addShape(new Rectangle(split2.x, split2.y, split2.width, split2.height));
        }
        
        // Mark this shape for removal by setting its size very small
        width = 1;
        height = 1;
    }
    
    private Shape createSplitShape(double newX, double newY, double newWidth, double newHeight) {
        Shape split = new Rectangle(newX, newY, newWidth, newHeight); // Temporary instance just for properties
        split.color = this.color;
        // Add some random variation to the velocities
        split.velocityX = this.velocityX * (0.8 + random.nextDouble() * 0.4); // 80-120% of original velocity
        split.velocityY = this.velocityY * (0.8 + random.nextDouble() * 0.4);
        return split;
    }

    public boolean intersects(Shape other) {
        return getBounds().intersects(other.getBounds());
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, (int)width, (int)height);
    }

    public void bounceOffWalls(int panelWidth, int panelHeight) {
        if (x <= 0 || x + width >= panelWidth) {
            velocityX = -velocityX;
        }
        if (y <= 0 || y + height >= panelHeight) {
            velocityY = -velocityY;
        }
    }

    public void applyGravity() {
        velocityY += 0.1; // Gravity constant
    }
}