package shapes;

/**
 * @author Mr Levin Created 10/16/2017 Lab 2.1 shapes
 *
 */
public class Rectangle implements Shape{
	
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }


    @Override
    public double calculateArea() {
    	return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return (length * 2 + width * 2);
    }

    @Override
    public String toString()
    {
        return "Rectangle Width: " + width + " Length: " + length + " Area: " + this.calculateArea() + " Perimeter: " + this.calculatePerimeter();
    }
}

