//Aarsh Patel
public class Bread {
	//Attributes: Name, Calories, Type
	private String name;
	private int calories;
	private String type;
	
	//Constructors
		//Default Constructor
	public Bread() {
		this.name = "none";
		this.calories = 50;
		this.type = "Whole Grain";
	}
		//Parameterized Constructor
	public Bread(String nameVal, int caloriesVal, String typeVal) {
		this.setName(nameVal);
		this.setCalories(caloriesVal);
		this.setType(typeVal);
	}
	
	//Accessors and Mutators
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name != null)
			this.name = name;
		else
			this.name = "none";
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		if (calories >= 50 && calories <= 250)
			this.calories = calories;
		else
			this.calories = 50;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		if (type.equalsIgnoreCase("Honey Wheat") || 
				type.equalsIgnoreCase("White") ||
				type.equalsIgnoreCase("Whole Grain") ||
				type.equalsIgnoreCase("Whole Wheat"))
			this.type = type;
		else
			this.type = "Whole Grain";
	}
	
	//equals method
	public boolean equals(Bread other) {
		return other != null && 
				this.name.equalsIgnoreCase(other.name) &&
				this.calories == other.calories &&
				this.type.equalsIgnoreCase(other.type);
	}
	
	//toString method
	public String toString() {
		return String.format("%n-Name: %s%n-Calories: %d%n-Type: %s%n", 
				this.name, this.calories, this.type);
	}
	
} //Bread end
