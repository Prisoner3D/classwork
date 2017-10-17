package shapes;

public class Circle implements Shape{
	private static double pi = 3.14;
	private double radius;
	public Circle(double rad)
	{
		this.radius = rad;
	}
	public double area()
	{
		return pi * this.radius * this.radius;
	}
	public double perimeter()
	{
		return 2 * this.radius * pi;
	}
}
