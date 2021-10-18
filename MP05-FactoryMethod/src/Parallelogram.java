import java.awt.*;

public class Parallelogram extends Shape {
    Parallelogram(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea() {
        double width = Math.abs(points[0].x-points[3].x);   // p1-p4 (y same)
        double height = Math.abs(points[0].y-points[2].y);  // p1-p3
        return width*height;
    }
}
