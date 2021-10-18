import java.awt.*;

public class Triangle extends Shape {
    Triangle(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea() {
        double distanceA = distance(points[0].x, points[0].y, points[1].x, points[1].y);
        double distanceB = distance(points[2].x, points[2].y, points[1].x, points[1].y);
        double distanceC = distance(points[0].x, points[0].y, points[2].x, points[2].y);
        double s = (distanceA+distanceB+distanceC)/2;
        return Math.sqrt(s*(s-distanceA)*(s-distanceB)*(s-distanceC));
    }

    private double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2));
    }
}
