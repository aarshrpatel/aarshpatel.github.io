/*
 * Aarsh Patel
 */
public class Task {
	//instance variables
	private String action;
	private int priority;
	
	//Constructors
	public Task()
	{
		this.priority = 4;
		this.action = "none";
	}
	
	public Task(int priority, String action)
	{
		this.setPriority(priority);
		this.setAction(action);
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		if(action != null)
			this.action = action;
		else
			this.action = "none";
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		if(priority >= 0 && priority <= 4)
			this.priority = priority;
		else
			this.priority = 4;
	}
	
	public String toString()
	{
		return "[Task] Priority: " + this.priority + "\t" + "Task: " + this.action;
	}
	
	public boolean equals(Task aTask)
	{
		return aTask != null && this.action.equals(aTask.getAction())
				&& this.priority == aTask.getPriority();
	}
	
}
