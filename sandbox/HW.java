package ru.stqa.pft.sandbox;

public class HW {
	public static void main(String[] args) {


		Point p1 = new Point(2,2);
		Point p2 = new Point(5,5);
		System.out.println("The distance between two points is " + distance(p1,p2));

	}


	public static double distance(Point p1, Point p2) {
		double x = Math.pow(p2.x - p1.x, 2);
		double y = Math.pow(p2.y - p1.y, 2);
		return Math.sqrt(x + y);
	}

}