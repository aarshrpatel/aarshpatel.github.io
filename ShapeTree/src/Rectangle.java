/*
 * Aarsh Patel
 */

public class Rectangle extends Shape {
	//Properties
	private double length;
	private double width;
	
	//Constructor
	public Rectangle(double aLength, double aWidth)
	{
		super("Rectangle", aLength * aWidth);//Construct shape and properties
		setLength(aLength);
		setWidth(aWidth);
	}
	
	public double getLength() {
		return length;
	}
	public void setLength(double aLength) {
		if(aLength >= 0.0)
			this.length = aLength;
		else
			this.length = 0.0;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double aWidth) {
		if(aWidth >= 0.0)
			this.width = aWidth;
		else 
			this.width = 0.0;
	}
	
	public String toString()
	{
		return "Rectangle Length: " + this.getLength() + " Width: " + this.getWidth() + " Area: " + super.getArea();
	}
	
}
