//Aarsh Patel
public class PeanutButter {
	//Attributes: Name, Calories, IsCrunchy
	private String name;
	private int calories;
	private boolean isCrunchy;
	
	//Constructors
		//Default Constructor
	public PeanutButter() {
		this.name = "none";
		this.calories = 100;
		this.isCrunchy = false;
	}
	
		//Parameterized Constructor
	public PeanutButter(String nameVal, int caloriesVal, 
			boolean isCrunchyVal) {
		this.setName(nameVal);
		this.setCalories(caloriesVal);
		this.setCrunchy(isCrunchyVal);
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
		if (calories >= 100 && calories <= 300)
			this.calories = calories;
		else
			this.calories = 100;
	}
	public boolean isCrunchy() {
		return isCrunchy;
	}
	public void setCrunchy(boolean isCrunchy) {
		if (isCrunchy == true)
			this.isCrunchy = isCrunchy;
		else
			this.isCrunchy = false;
	}
	
	
	//equals method
	public boolean equals(PeanutButter other) {
		return other != null && 
				this.name.equalsIgnoreCase(other.name) &&
				this.calories == other.calories &&
				this.isCrunchy == other.isCrunchy;
	}
	
	//toString method
	public String toString() {
		return String.format("%n-Name: %s%n-Calories: %d%n-Is Crunchy: %b",
				this.name, this.calories, this.isCrunchy);
	}
}
