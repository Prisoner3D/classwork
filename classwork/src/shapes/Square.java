package shapes;

/**
 * @author Mr Levin Created 10/16/2017 Lab 2.1 shapes
 * @author Thomas Edited for Lab 2.1
 */

public class Square extends Rectangle {
	
    private int side;

    public Square(int side)
    {
        super(side, side);
        this.side = side;
    }

    @Override
    public String toString()
    {
    	return "Square Width: " + side + " Length: " + side + " Area: " + this.calculateArea() + " Perimeter: " + this.calculatePerimeter();
    }

}
