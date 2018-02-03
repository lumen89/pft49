package ru.stqa.pft.sandbox;



public class Point {

    public double x;
    public double y;


    public Point (double x, double y) {
        this.x = x;
        this.y= y;
    }


    public  double distance(Point p1) {
        double v = Math.pow(this.x - p1.x, 2);
        double t = Math.pow(this.y - p1.y, 2);
        return Math.sqrt(v + t);
    }


}