package com.epam.rd.autotasks.segments;

class Segment {
    private Point start;
    private Point end;

    public Segment(Point start, Point end) {
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new RuntimeException("Start and end points are the same");
        }
        this.start = start;
        this.end = end;
    }

    public double length() {
        return Math.sqrt(Math.pow(end.getX() - start.getX(),2) + Math.pow(end.getY() - start.getY(),2));
    }

    public Point middle() {
        return new Point((start.getX() + end.getX()) / 2.0, (start.getY() + end.getY()) / 2.0);
    }
    public Point intersection(Segment another) {
        double x1 = start.getX();
        double y1 = start.getY();
        double x2 = end.getX();
        double y2 = end.getY();
        double x3 = another.start.getX();
        double y3 = another.start.getY();
        double x4 = another.end.getX();
        double y4 = another.end.getY();
        double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (denominator == 0) {
            return null;
        }
        double xIntersection = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / denominator;
        double yIntersection = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / denominator;
        Point intersection = new Point(xIntersection, yIntersection);
        if (isPointOnSegment(intersection) && another.isPointOnSegment(intersection)) {
            return intersection;
        }
        return null;
    }

    private boolean isPointOnSegment(Point point) {
        return point.getY() >= Math.min(start.getX(), end.getX()) && point.getX() <= Math.max(start.getX(), end.getX()) && point.getY() >=
                Math.min(start.getY(), end.getY()) && point.getY() <= Math.max(start.getY(), end.getY());
    }
}
