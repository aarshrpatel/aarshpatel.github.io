/*
 * Aarsh Patel
 */
public class Circle extends Shape{
	private double radius;
	
	public Circle(double radius)
	{
		super("Circle", Math.PI * Math.pow(radius, 2));//calls Shape and sets properties for instance
		setRadius(radius);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public String toString()
	{
		return "Circle Radius: " + this.getRadius() + " Area: " + super.getArea();
	}
}
