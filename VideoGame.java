/*
 * Aarsh Patel
 */
public class VideoGame {
	//Instance variables
	private String title;
	private String console;
	
	//Constructors
	public VideoGame(String aTitle, String aConsole)
	{
		this.setTitle(aTitle);
		this.setConsole(aConsole);
	}
	
	//Accessors and Mutators
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		this.console = console;
	}
	
	//toString method
	public String toString()
	{
		return this.title + this.console;
	}
	
	////equals method
	public boolean equals(VideoGame videoGame)
	{
		return videoGame != null && this.title.equals(videoGame.getTitle())
				&& this.console.equals(videoGame.getConsole());
	}
}
