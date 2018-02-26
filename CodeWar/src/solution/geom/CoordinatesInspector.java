package solution.geom;

import java.awt.geom.Point2D;

/**
 * http://www.codewars.com/kata/cartesian-coordinates-from-degree-angle/java
 * DONE
 * */

public class CoordinatesInspector {

    public Point2D coordinates(Double degrees, Double radius) {
        double ct = 10000000000d;
        double px = (radius * Math.cos(degrees * Math.PI / 180.0f));
        double py = (radius * Math.sin(degrees * Math.PI / 180.0f));
        Point2D.Double point2D = new Point2D.Double(Math.round(px*ct)/ct, Math.round(py*ct)/ct);
        return point2D;
    }


    public static void main(String[] args) {
        CoordinatesInspector coordinatesInspector = new CoordinatesInspector();
        System.out.println(coordinatesInspector.coordinates(90d,1d).toString());
        System.out.println(coordinatesInspector.coordinates(45d,1d).toString());
    }
}
