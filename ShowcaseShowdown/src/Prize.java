/*
 * Aarsh Patel
 */

//Packages

public class Prize {
	private String name;
	private double price;
	
	public Prize()
	{
		this.setName("none");
		this.setPrice(0);
	}
	
	public Prize(String aName, double aPrice)
	{
		setName(aName);
		setPrice(aPrice);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null)
			this.name = "none";
		else
			this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if(price > 0.0)
			this.price = price;
		else
			this.price = 0.0;
	}
	
	public boolean equals(Prize aPrize)
	{
		return aPrize != null && this.name.equals(aPrize.getName()) 
				&& this.price == aPrize.getPrice();
	}
	
	public String toString()
	{
		return "Prize Name: " + this.name + " Price: $" + this.price;
	}
}
