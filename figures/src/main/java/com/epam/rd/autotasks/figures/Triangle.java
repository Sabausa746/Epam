package com.epam.rd.autotasks.figures;

import java.util.*;

class Triangle extends Figure {
    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public double area() {
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double x3 = p3.getX();
        double y3 = p3.getY();

        double a = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double b = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        double c = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));

        double p = (a + b + c) / 2.0;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));

    }

    public String pointsToString() {
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double x3 = p3.getX();
        double y3 = p3.getY();

        return String.format("(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)", x1, y1, x2, y2, x3, y3);
    }

    public String toString() {
        return "Triangle[" + pointsToString() + ']';
    }

    @Override
    public Point leftmostPoint() {
        ArrayList<Point> points;
        points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);

        return points.stream().min(Comparator.comparing(Point::getX)).get();
    }

}
