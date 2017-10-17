package shapes;

public class ShapeRunner {
	public static void main(String[] args) {
		Rectangle rect = new Rectangle(5,3);
		Circle circ = new Circle(3);
		if (rect.area() > circ.area())
		{
			System.out.println(rect.area());
		}
		else
		{
			System.out.println(circ.area());
		}
		if (rect.perimeter() > circ.perimeter())
		{
			System.out.println(rect.perimeter());
		}
		else
		{
			System.out.println(circ.perimeter());
		}
	}
}
