import java.util.ArrayList;

public class Polygon {

    public Point2[] coords;

    Polygon(Point2[] coords) {
        if(coords.length < 3) {
            throw new RuntimeException("Invalid amount of coordinates");
        }
        this.coords = coords;
    }

    public float getAreaByGeron(Point2[] coords) {
        double sideA = Math.sqrt(Math.pow(coords[1].x - coords[0].x, 2) + Math.pow(coords[1].y - coords[0].y, 2));
        double sideB = Math.sqrt(Math.pow(coords[2].x - coords[1].x, 2) + Math.pow(coords[2].y - coords[1].y, 2));
        double sideC = Math.sqrt(Math.pow(coords[2].x - coords[0].x, 2) + Math.pow(coords[2].y - coords[0].y, 2));
        double P = sideA + sideB + sideC;
        double p = P / 2;
        double area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        return (float) area;
    }

    public float getArea(Point2[] coords) {
        if(coords.length == 3) {
            return getAreaByGeron(coords);
        }

        float area = 0;
        ArrayList<Point2> pointsForNewPolygon = new ArrayList();
        for (int i = 0; i < coords.length; i += 2) {
            if(i == coords.length - 1) {
                area += getArea(new Point2[] {coords[i], coords[0], coords[i-2]});
                continue;
            } else if(i == coords.length - 2) {
                area += getArea(new Point2[] {coords[i], coords[i+1], coords[0]});
            } else {
                area += getArea(new Point2[] {coords[i], coords[i+1], coords[i+2]});
            }
            pointsForNewPolygon.add(coords[i]);
        }
        if(pointsForNewPolygon.size() >= 3) {
            area += getArea(pointsForNewPolygon.toArray(new Point2[0]));
        }

        return area;
    }

    public float getArea() {
        return getArea(this.coords);
    }

}
