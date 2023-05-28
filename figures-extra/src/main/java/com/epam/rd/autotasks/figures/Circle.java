package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        if(center == null || radius <= 0){
            throw new IllegalArgumentException();
        }
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
    public Point centroid() {
        return center;
    }

    @Override
    public boolean isTheSame(Figure figure) {
       if(!figure.getClass().equals(this.getClass())) {
           return false;
       }
        double otherX = ((Circle) figure).center.getX();
        double otherY = ((Circle) figure).center.getY();
        double thisX = center.getX();
        double thisY = center.getY();
        double otherRadius = ((Circle) figure).radius;
        double thisRadius = radius;


        return isDoubleEqual(thisY, otherY) && isDoubleEqual(thisX, otherX) && isDoubleEqual(thisRadius, otherRadius);

    }

    public boolean isDoubleEqual(double d1, double d2){
        return Math.abs(d1-d2) < 0.00001;

    }
}
