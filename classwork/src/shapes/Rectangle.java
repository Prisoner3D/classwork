package shapes;

/**
 * @author Mr Levin Created 10/16/2017 Lab 2.1 shapes
 * @author Thomas Edited for Lab 2.1
 */

public class Rectangle implements Shape {
	
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.setLength(length);
        this.setWidth(width);
    }


    @Override
    public double calculateArea() {
    	return getLength() * getWidth();
    }

    @Override
    public double calculatePerimeter() {
        return (getLength() * 2 + getWidth() * 2);
    }

    @Override
    public String toString()
    {
        return "Rectangle Width: " + getWidth() + " Length: " + getLength() + " Area: " + this.calculateArea() + " Perimeter: " + this.calculatePerimeter();
    }

    //Getters and Setters

	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}
}

