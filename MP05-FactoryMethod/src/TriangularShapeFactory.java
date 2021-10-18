import java.awt.*;

public class TriangularShapeFactory implements ShapeFactory {
    @Override
    public Shape create(String type, Point[] points) {
        Shape sh = null;
        if (type.equals("Triangle")) {
            sh = new Triangle(type, points);
        } else if (type.equals("RightTriangle")) {
            sh = new RightTriangle(type, points);
        }
        return sh;
    }
}
