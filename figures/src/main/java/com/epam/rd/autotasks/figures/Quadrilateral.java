package com.epam.rd.autotasks.figures;

import java.util.ArrayList;
import java.util.Comparator;

class Quadrilateral extends Figure {
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public double area() {
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double x3 = p3.getX();
        double y3 = p3.getY();
        double x4 = p4.getX();
        double y4 = p4.getY();

        double a = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double b = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double c = Math.sqrt(Math.pow(x4 - x3, 2) + Math.pow(y4 - y3, 2));
        double d = Math.sqrt(Math.pow(x1 - x4, 2) + Math.pow(y1 - y4, 2));

        double diagonal = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));

        double p1 = (a + b + diagonal) / 2.0;
        double p2 = (c + d + diagonal) / 2.0;

        double area1 = Math.sqrt(p1 * (p1 - a) * (p1 - b) * (p1 - diagonal));
        double area2 = Math.sqrt(p2 * (p2 - c) * (p2 - d) * (p2 - diagonal));

        return area2 + area1;
    }

    public String pointsToString() {
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double x3 = p3.getX();
        double y3 = p3.getY();
        double x4 = p4.getX();
        double y4 = p4.getY();

        return String.format("(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)", x1, y1, x2, y2, x3, y3, x4, y4);
    }

    public String toString() {
        return "Quadrilateral[" + pointsToString() + ']';
    }

    @Override
    public Point leftmostPoint() {
        ArrayList<Point> points;
        points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);

        return points.stream().min(Comparator.comparing(Point::getX)).get();
    }
}
