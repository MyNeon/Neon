package example;

public class Point {
	double X;
	double Y;
	public Point(double x, double y) {
		this.X = x;
		this.Y = y;
	}
	public void GetPoint() {
		System.out.print("[");
		System.out.print(this.X);
		System.out.print(", ");
		System.out.print(this.Y);
		System.out.println("]");
	}
}
