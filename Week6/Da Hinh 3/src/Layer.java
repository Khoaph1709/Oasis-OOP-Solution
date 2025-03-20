import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Layer extends JPanel implements KeyListener, ActionListener {
    private static Layer instance;
    
    public static void addShape(Shape shape) {
        if (instance != null) {
            instance.shapes.add(shape);
        }
    }
    private List<Shape> shapes;
    private boolean gravityEnabled;
    private Timer timer;

    public Layer() {
        instance = this;
        shapes = new ArrayList<>();
        gravityEnabled = false;
        setFocusable(true);
        addKeyListener(this);
        timer = new Timer(16, this); // ~60 FPS
        timer.start();

        // Add gravity toggle button
        JButton gravityButton = new JButton("Toggle Gravity");
        gravityButton.addActionListener(e -> gravityEnabled = !gravityEnabled);
        add(gravityButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Shape shape : shapes) {
            shape.draw(g2d);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update physics
        for (Shape shape : shapes) {
            shape.move();
            if (gravityEnabled) {
                shape.applyGravity();
            }
            shape.bounceOffWalls(getWidth(), getHeight());
        }

        // Check collisions
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i + 1; j < shapes.size(); j++) {
                Shape shape1 = shapes.get(i);
                Shape shape2 = shapes.get(j);
                if (shape1.intersects(shape2)) {
                    shape1.handleCollision(shape2);
                    shape2.handleCollision(shape1);
                }
            }
        }

        // Remove small shapes
        Iterator<Shape> iterator = shapes.iterator();
        while (iterator.hasNext()) {
            Shape shape = iterator.next();
            if (shape.width < 5 || shape.height < 5) {
                iterator.remove();
            }
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'c':
                shapes.add(Circle.createRandom(getWidth(), getHeight()));
                break;
            case 'r':
                shapes.add(Rectangle.createRandom(getWidth(), getHeight()));
                break;
            case 'd': // Delete overlapping shapes
                removeOverlappingShapes();
                break;
            case 'x': // Delete all circles
                removeAllCircles();
                break;
        }
        repaint();
    }

    private void removeOverlappingShapes() {
        List<Shape> shapesToRemove = new ArrayList<>();
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i + 1; j < shapes.size(); j++) {
                if (shapes.get(i).intersects(shapes.get(j))) {
                    shapesToRemove.add(shapes.get(i));
                    shapesToRemove.add(shapes.get(j));
                }
            }
        }
        shapes.removeAll(shapesToRemove);
    }

    private void removeAllCircles() {
        shapes.removeIf(shape -> shape instanceof Circle);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}