package shapes;

public class Parallelogram extends Rectangle{

	private double angle;
	
	public Parallelogram(int length, int width,double angle)
	{
		super(length,width);
		this.angle = angle;
	}
	@Override
	public double calculateArea() {
		
		return 0;
	}

	@Override
	public double calculatePerimeter() {
		
		return 0;
	}

	public String toString()
    {
    	return "Parallelogram Sides: " + side1 + side2 + side3 + side4 + " Area: " + this.calculateArea() + " Perimeter: " + this.calculatePerimeter();
    }
}
