import java.awt.*;

public abstract class Shape {
    protected String type;
    protected Point[] points;

    public Shape(String type, Point[] points) {
        this.type = type;
        this.points = points;
    }

    public abstract double calcArea();

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder(type + '\n');
        for (int i = 0;i < points.length;i++)
            ret.append("p").append(i).append(": ").append(points[i].toString()).append('\n');
        ret.append("area: ").append(calcArea()).append('\n');
        return ret.toString();
    }
}
