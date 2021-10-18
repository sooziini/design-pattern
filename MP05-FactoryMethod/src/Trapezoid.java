import java.awt.*;

public class Trapezoid extends Shape {
    Trapezoid(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea() {
        double widthA = Math.abs(points[0].x-points[3].x);   // p1-p4 (y same)
        double widthB = Math.abs(points[2].x-points[1].x);   // p3-p2 (y same)
        double height = Math.abs(points[0].y-points[2].y);   // p1-p3
        return (widthA+widthB)*height/2;
    }
}
