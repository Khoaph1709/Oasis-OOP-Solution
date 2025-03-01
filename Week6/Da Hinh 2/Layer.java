import java.util.ArrayList;

public class Layer {
    private ArrayList<Shape> shapes;

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeCircle() {
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) instanceof Circle) {
                shapes.remove(i);
                i--;
            }
        }
    }

    public void getInfo() {
        System.out.println("Layer of crazy shapes:");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    public void removeDuplicates() {
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = i; j < shapes.size(); j++) {
                if (shapes.get(i).equals(shapes.get(j))) {
                    shapes.remove(j);
                    j--;
                }
            }
        }
    }
}
