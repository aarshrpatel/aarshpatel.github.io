/*
 * Aarsh Patel
 */

public class Shape implements Comparable<Shape> {
	private String type;
	private double area;
	
	public Shape(String aType, double anArea)
	{
		setType(aType);
		setArea(anArea);
	}
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if(type.equalsIgnoreCase("rectangle") || type.equalsIgnoreCase("circle") 
				|| type.equalsIgnoreCase("right triangle"))
			this.type = type;
		else
			return;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		if(area >= 0.0)
			this.area = area;
		else
			return;
	}

	public int compareTo(Shape aShape) {
		if(aShape == null)
			return -1;
		if(this.area > aShape.getArea())
			return 1;
		else if(this.area < aShape.getArea())
			return -1;
		else 
		{
			if(this.type.equalsIgnoreCase("circle") && 
					(aShape.getType().equalsIgnoreCase("rectangle") || aShape.getType().equalsIgnoreCase("right triangle")))
			{
				//TODO find a way to compare Circle, Rectangle, and Right Triangle with the same area
			}
			
			//TODO if the area and the type are the same, then do not add the duplicate shape
		return 0;
		}
	}
	
	
}
