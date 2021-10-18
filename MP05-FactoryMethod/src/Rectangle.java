import java.awt.*;

public class Rectangle extends Shape {
    Rectangle(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea() {
        double width = Math.abs(points[0].x-points[1].x);
        double height = Math.abs(points[0].y-points[1].y);
        return width*height;
    }
}
