package com.epam.rd.autotasks.figures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Quadrilateral extends Figure {
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;
    private double a;
    private double b;
    private double c;
    private double d;
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;
    private double x4;
    private double y4;


    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        if(p1==null||p2==null||p3==null||p4==null){
            throw new IllegalArgumentException();
        }

        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        x1 = p1.getX();
        y1 = p1.getY();
        x2 = p2.getX();
        y2 = p2.getY();
        x3 = p3.getX();
        y3 = p3.getY();
        x4 = p4.getX();
        y4 = p4.getY();

        a = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        b = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        c = Math.sqrt(Math.pow(x4 - x3, 2) + Math.pow(y4 - y3, 2));
        d = Math.sqrt(Math.pow(x1 - x4, 2) + Math.pow(y1 - y4, 2));

        if (isDegenerate() || !isConvex()) {
            throw new IllegalArgumentException("Quadrilateral is degenerate.");
        }
    }

    private boolean isDegenerate() {
        // Check if any three consecutive points are collinear
        boolean col1 = (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) == 0;
        boolean col2 = (x2 * (y3 - y4) + x3 * (y4 - y2) + x4 * (y2 - y3)) == 0;
        boolean col3 = (x3 * (y4 - y1) + x4 * (y1 - y3) + x1 * (y3 - y4)) == 0;
        boolean col4 = (x4 * (y1 - y2) + x1 * (y2 - y4) + x2 * (y4 - y1)) == 0;

        // Check if any two consecutive sides have zero length
        boolean AB = a == 0;
        boolean BC = b == 0;
        boolean CD = c == 0;
        boolean DA = d == 0;

        // Quadrilateral is degenerate if any of the conditions are met
        return col1 || col2 || col3 || col4 ||
                AB || BC || CD || DA;
    }

    private boolean isConvex() {
        double crossProduct1 = (x2 - x1) * (y3 - y2) - (y2 - y1) * (x3 - x2);
        double crossProduct2 = (x3 - x2) * (y4 - y3) - (y3 - y2) * (x4 - x3);
        double crossProduct3 = (x4 - x3) * (y1 - y4) - (y4 - y3) * (x1 - x4);
        double crossProduct4 = (x1 - x4) * (y2 - y1) - (y1 - y4) * (x2 - x1);

        return (crossProduct1 > 0 && crossProduct2 > 0 && crossProduct3 > 0 && crossProduct4 > 0)
                || (crossProduct1 < 0 && crossProduct2 < 0 && crossProduct3 < 0 && crossProduct4 < 0);
    }


    public double area() {


        double diagonal = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));

        double p1 = (a + b + diagonal) / 2.0;
        double p2 = (c + d + diagonal) / 2.0;

        double area1 = Math.sqrt(p1 * (p1 - a) * (p1 - b) * (p1 - diagonal));
        double area2 = Math.sqrt(p2 * (p2 - c) * (p2 - d) * (p2 - diagonal));

        return area2 + area1;
    }

    public String pointsToString() {
        return String.format("(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)(%.1f,%.1f)", x1, y1, x2, y2, x3, y3, x4, y4);
    }

    public String toString() {
        return "Quadrilateral[" + pointsToString() + ']';
    }

    @Override
    public Point centroid() {
        // Calculate the centroids of the two triangles formed by the quadrilateral
        double triangle1CentroidX = (x1 + x2 + x3) / 3;
        double triangle1CentroidY = (y1 + y2 + y3) / 3;
        double triangle2CentroidX = (x1 + x3 + x4) / 3;
        double triangle2CentroidY = (y1 + y3 + y4) / 3;

        // Calculate the areas of the two triangles
        double triangle1Area = 0.5 * Math.abs((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3));
        double triangle2Area = 0.5 * Math.abs((x1 - x4) * (y3 - y4) - (x3 - x4) * (y1 - y4));

        // Calculate the weighted average of the triangle centroids to get the quadrilateral centroid
        double centroidX = (triangle1Area * triangle1CentroidX + triangle2Area * triangle2CentroidX) / (triangle1Area + triangle2Area);
        double centroidY = (triangle1Area * triangle1CentroidY + triangle2Area * triangle2CentroidY) / (triangle1Area + triangle2Area);

        return new Point(centroidX, centroidY);

    }

    @Override
    public boolean isTheSame(Figure figure) {
        if(!(figure instanceof Quadrilateral)){
            return false;
        }
        Quadrilateral other = (Quadrilateral) figure;
        List<Double> thisList = getSideLengths();
        List<Double> otherList = other.getSideLengths();

        otherList.forEach(thisList::remove);
        return thisList.isEmpty();

    }

    public List<Double> getSideLengths(){
        List<Double> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);

        return list;
    }






}
