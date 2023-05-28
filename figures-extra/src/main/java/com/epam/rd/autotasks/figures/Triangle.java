package com.epam.rd.autotasks.figures;

import java.nio.channels.Pipe;
import java.util.*;

class Triangle extends Figure {
    private Point p1;
    private Point p2;
    private Point p3;
    private double a;
    private double b;
    private double c;

    public Triangle(Point p1, Point p2, Point p3) {
        if(p1 == null || p2==null || p3 == null){
            throw new IllegalArgumentException();
        }

        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double x3 = p3.getX();
        double y3 = p3.getY();

        // Calculate the lengths of the sides of the triangle
        double a = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double b = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        double c = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));

        if ((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) == 0) {
            throw new IllegalArgumentException("Points are collinear, resulting in a degenerate triangle.");
        }

        if ((a + b) <= c || (a + c) <= b || (c + b) <= a) {
            throw new IllegalArgumentException("Triangle is degenerate.");
        }

    }

    public double area() {
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

    public List<Double> getSideLengths(){
        List<Double> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);

        return list;
    }

    @Override
    public Point centroid() {
        return new Point((p1.getX()+p2.getX()+p3.getX())/3.0,(p1.getY()+p2.getY()+p3.getY())/3.0);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return figure.getClass().equals(this.getClass()) && checkSides((Triangle) figure);
    }
    private boolean checkSides(Triangle figure){
        List<Double> thisList = getSideLengths();
        List<Double> otherList = figure.getSideLengths();

        otherList.forEach(thisList::remove);
        return thisList.isEmpty();
    }
}
