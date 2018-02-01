package ru.stqa.pft.sandbox;



public class Point {

    public final double x;
    public final double y;


    public Point (double x, double y) {
        this.x = x;
        this.y= y;
    }


    public  double distance(Point p1) {
        double v = Math.pow(this.x - p1.x, 2);
        double t = Math.pow(this.y - p1.y, 2);
       return Math.sqrt(v + t);
    }

   /* public static double distance1(Point p1, Point p2) {
        double v = Math.pow(p2.x - p1.x, 2);
        double t = Math.pow(p2.y - p1.y, 2);
        return Math.sqrt(v + t);
    }


    public static void main(String[] args) {
        Point p1 = new Point(2,4);
        Point p5 = new Point(4,6);
        p1.distance(p5);
    }
*/

}