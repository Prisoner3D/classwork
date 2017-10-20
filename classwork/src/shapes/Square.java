package shapes;

public class Square extends Rectangle {
	
    private int side;

    public Square(int side)
    {
        super(side,side);
        this.side = side;
    }

    @Override
    public String toString()
    {
    	return "Square Width: " + side + " Length: " + side + " Area: " + this.calculateArea() + " Perimeter: " + this.calculatePerimeter();
    }

}
