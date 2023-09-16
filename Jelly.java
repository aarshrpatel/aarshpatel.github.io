//Aarsh Patel
public class Jelly {
	//Attributes: Name, Calories, Type
	private String name;
	private int calories;
	private String fruitType;
	
	//Constructors
		//Default Constructor
	public Jelly() {
		this.name = "none";
		this.calories = 50;
		this.fruitType = "Grape";
	}
		//Parameterized Constructor
	public Jelly(String nameVal, int caloriesVal, String fruitTypeVal) {
		this.setName(nameVal);
		this.setCalories(caloriesVal);
		this.setFruitType(fruitTypeVal);
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
		if (calories >= 50 && calories <= 200)
			this.calories = calories;
		else
			this.calories = 50;
	}
	public String getFruitType() {
		return fruitType;
	}
	public void setFruitType(String type) {
		if (type.equalsIgnoreCase("Apple") || 
				type.equalsIgnoreCase("Blackberry") ||
				type.equalsIgnoreCase("Grape") ||
				type.equalsIgnoreCase("Blueberry") ||
				type.equalsIgnoreCase("Tomato"))
			this.fruitType = type;
		else
			this.fruitType = "Grape";
	}
	
	//equals method
	public boolean equals(Jelly other) {
		return other != null && 
				this.name.equalsIgnoreCase(other.name) &&
				this.calories == other.calories &&
				this.fruitType.equalsIgnoreCase(other.fruitType);
	}
	
	//toString method
	public String toString() {
		return String.format("%n-Name: %s%n-Calories: %d%n-Fruit Type: %s", 
				this.name, this.calories, this.fruitType);
	}
}
