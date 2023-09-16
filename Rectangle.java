
public class Rectangle {
	//properties
	private double length;
	private double width;
		
	//Constructors
	public Rectangle() {
		this.length = 0.0;
		this.width = 0.0;
	}
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
		
	//Accessors and Mutators
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
		
	//Methods
	public double getArea() {
		return this.length * this.width;
	}
	
	//equals method
//	public boolean equals(Rectangle other) {
//		return this.getArea
//	}
}

