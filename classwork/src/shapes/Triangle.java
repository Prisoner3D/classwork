package shapes;

public class Triangle implements Shape{
	private int side1;
	private int side2;
	private int side3;
	
	public Triangle(int side1, int side2, int side3)
	{
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	@Override
    public double calculateArea() {
		int s = (this.side1 + this.side2 + this.side3) / 2;
    	return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double calculatePerimeter()
    {
    	return side1 + side2 + side3;
    }

    @Override
    public String toString()
    {
    	return "Triangle Sides:" + side1 + side2 + side3  + " Area: " + this.calculateArea() + " Perimeter: " + this.calculatePerimeter();
    }
}
