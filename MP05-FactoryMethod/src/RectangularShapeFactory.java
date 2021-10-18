import java.awt.*;

public class RectangularShapeFactory implements ShapeFactory {
    @Override
    public Shape create(String type, Point[] points) {
        Shape sh = null;
        if (type.equals("Rectangle")) {
            sh = new Rectangle(type, points);
        } else if (type.equals("Trapezoid")) {
            sh = new Trapezoid(type, points);
        } else if (type.equals("Parallelogram")) {
            sh = new Parallelogram(type, points);
        }
        return sh;
    }
}
