//Aarsh Patel
public class PBJSandwich {
	//Attributes and Variables: Top Slice, Peanut Butter, Jelly, Bottom Slice
	private Bread topSlice;
	private PeanutButter peanutButter;
	private Jelly jelly;
	private Bread bottomSlice;
	
	//Constructors
		//Default
	public PBJSandwich() {
		
	}
		//Parameterized
	public PBJSandwich(Bread top, PeanutButter pb, Jelly jelly, Bread bottom) {
		this.setTopSlice(top);
		this.setPeanutButter(pb);
		this.setJelly(jelly);
		this.setBottomSlice(bottom);
	}
	
	//Accessors and Mutators

	public Bread getTopSlice() {
		return topSlice;
	}

	public void setTopSlice(Bread topSlice) {
		this.topSlice = topSlice;
	}

	public PeanutButter getPeanutButter() {
		return peanutButter;
	}

	public void setPeanutButter(PeanutButter peanutButter) {
		this.peanutButter = peanutButter;
	}

	public Jelly getJelly() {
		return jelly;
	}

	public void setJelly(Jelly jelly) {
		this.jelly = jelly;
	}

	public Bread getBottomSlice() {
		return bottomSlice;
	}

	public void setBottomSlice(Bread bottomSlice) {
		this.bottomSlice = bottomSlice;
	}
	
	//equals method
	public boolean equals(PBJSandwich other) {
		return this.topSlice != null && other.topSlice != null &&
				this.topSlice.equals(other.topSlice) &&
				this.peanutButter != null && other.peanutButter != null &&
				this.peanutButter.equals(other.peanutButter) &&
				this.jelly != null && other.jelly != null &&
				this.jelly.equals(other.jelly) &&
				this.bottomSlice != null && other.bottomSlice != null &&
				this.bottomSlice.equals(other.bottomSlice);
	}
	
	//toString method
	public String toString() {
		return String.format("---PB&J Sandwich---%nTop Slice: %s%n%nPB: "
				+ "%s%n%nJelly: %s%n%nBottom Slice: %s%n",
				this.topSlice, this.peanutButter, this.jelly, this.bottomSlice);
	}

}
