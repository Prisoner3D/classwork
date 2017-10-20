package shapes;

public class Triangle implements Shape {

	private int side1;
	private int side2;
	private int side3;
	
	public Triangle(int side1, int side2, int side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	@Override
    public double calculateArea() {
		int s = (side1 + side2 + side3) / 2;
    	return 0;
    }

    @Override
    public double calculatePerimeter()
    {
    	return side1 + side2 + side3;
    }

    @Override
    public String toString()
    {
    	return "Circle Sides:" + side1 + side2 + side3 + " Area: " + this.calculateArea() + " Perimeter: " + this.calculatePerimeter();
    }
}
