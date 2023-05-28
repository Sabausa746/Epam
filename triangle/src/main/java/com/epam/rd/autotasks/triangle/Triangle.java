package com.epam.rd.autotasks.triangle;

class Triangle {
    private Point a;
    private Point b;
    private Point c;
    double aSide;
    double bSide;
    double cSide;


    public Triangle(Point a, Point b, Point c)  {
        double x1 = a.getX();
        double y1 = a.getY();
        double x2 = b.getX();
        double y2 = b.getY();
        double x3 = c.getX();
        double y3 = c.getY();
        this.a = a;
        this.b = b;
        this.c = c;

        aSide = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        bSide = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        cSide = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));

        if(aSide + bSide <= cSide || aSide + cSide <= bSide || cSide + bSide <= aSide){
            throw new RuntimeException();
        }
    }

    public double area() {

        double p = (aSide + bSide + cSide) / 2.0;

        return Math.sqrt(p * (p - aSide) * (p - bSide) * (p - cSide));
    }

    public Point centroid(){
        return new Point((a.getX()+b.getX()+c.getX())/3.0,(a.getY()+b.getY()+c.getY())/3.0);
    }

}
