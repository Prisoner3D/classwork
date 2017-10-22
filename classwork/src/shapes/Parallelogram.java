package shapes;

/**
 * @author Thomas Created for Lab 2.1
 */

public class Parallelogram extends Rectangle { //Shouldn't Rectangle extends Parallelogram?

	private double angle;
	
	public Parallelogram(int length, int width, double angle)
	{
		super(length,width);
		this.angle = angle;
	}
	
	@Override
	public double calculateArea() {
		double tempAngle = angle;
		return getWidth() * Math.sin(Math.toRadians(tempAngle)) * getLength();
	}

	public String toString()
    {
    	return "Parallelogram Sides: "  + " Area: " + this.calculateArea() + " Perimeter: " + this.calculatePerimeter();
    }
}
