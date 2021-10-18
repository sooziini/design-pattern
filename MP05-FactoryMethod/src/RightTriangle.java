import java.awt.*;

public class RightTriangle extends Shape {
    RightTriangle(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea() {
        double width = Math.abs(points[1].x-points[2].x);   // p2-p3 (y same)
        double height = Math.abs(points[0].y-points[2].y);  // p1-p3
        return width*height/2;
    }
}
