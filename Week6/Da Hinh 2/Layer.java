import java.util.ArrayList;
import java.util.List;

public class Layer {
    private List<Shape> shapes = new ArrayList<>();
    private int count = 0;

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Removes all Circle objects from the list of shapes in the layer.
     * This method iterates through the collection of shapes and eliminates
     * any object that is an instance of the Circle class.
     */
    public void removeCircles() {
        shapes.removeIf(shape -> shape instanceof Circle);
    }

    /**
     * Provides a string representation of the layer containing all shapes.
     * The information includes a list of the shapes in the layer.
     *
     * @return a string describing the layer of shapes, including details of each shape.
     */
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Layer of crazy shapes:\n");
        for (Shape shape : shapes) {
            sb.append(shape).append("\n");
        }

        return sb.toString();
    }

    /**
     * Removes duplicate shapes from the list of shapes in the layer.
     * This method iterates through the list and removes any duplicate objects
     * by comparing shapes using their overridden equals method.
     * Duplicate shapes are removed in-place, and the list's structure is updated.
     */
    public void removeDuplicates() {
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = i + 1; j < shapes.size(); j++) {
                if (shapes.get(i).equals(shapes.get(j))) {
                    shapes.remove(j);
                    j--;
                }
            }
        }
    }
}
