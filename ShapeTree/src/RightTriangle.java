/*
 * Aarsh Patel
 */

public class RightTriangle extends Shape {
	//Properties
	private double base;
	private double height;
	
	//Constructor
	public RightTriangle(double aBase, double aHeight)
	{
		super("Rigth Triangle", 0.5 * aBase * aHeight);
		setBase(aBase);
		setHeight(aHeight);
	}
	
	//Accessors and Mutators
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		if(base >= 0.0)
			this.base = base;
		else
			this.base = 0.0;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		if(height >= 0.0)
			this.height = height;
		else
			this.height = 0.0;
	}
	
	public String toString()
	{
		return "Right Triangle Base: " + this.getBase() + " Height: " + this.getHeight() + " Area: " + super.getArea();
	}
}
