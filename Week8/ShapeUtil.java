import java.util.List;

public class ShapeUtil {
    public String printInfo(List<GeometricObject> shapes) {
        StringBuilder result = new StringBuilder();
        result.append("Circle: \n");
        for (GeometricObject shape : shapes) {
            if (shape instanceof Circle) {
                result.append(shape.getInfo()).append("\n");
            }
        }
        result.append("Triangle: \n");
        for (GeometricObject shape1 : shapes) {
            if (shape1 instanceof Triangle) {
                result.append(shape1.getInfo()).append("\n");
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        List<GeometricObject> shapes = List.of(
                new Circle(new Point(1,2), 2.0),
                new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4)),
                new Circle(new Point(2, 3), 4.0),
                new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4))
        );

        ShapeUtil util = new ShapeUtil();
        System.out.println(util.printInfo(shapes));
    }
}
