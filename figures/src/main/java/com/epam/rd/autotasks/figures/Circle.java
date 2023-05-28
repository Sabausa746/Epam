package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public String pointsToString() {
        return String.format("(%.1f,%.1f)", center.getX(), center.getY());
    }

    public String toString() {
        String radiusString = String.valueOf(radius);
        if (radius < 1.0) {
            radiusString = !radiusString.contains(".") ? radiusString : radiusString.replaceAll("0*$", "").replaceAll("\\.$", "");
        }
        return String.format("Circle[%s%s]", pointsToString(), radiusString);


    }

    @Override
    public Point leftmostPoint() {
        return new Point(center.getX() - radius, center.getY());
    }
}
