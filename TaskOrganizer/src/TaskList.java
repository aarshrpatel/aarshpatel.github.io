/*
 * Aarsh Patel
 */

//packages
import java.util.Scanner;
import java.io.*;

public class TaskList {
	
	private GenLL<Task>[] organizedTasks;
	
	public TaskList()
	{
		
		organizedTasks = new GenLL[5];
		
		for(int i = 0; i < organizedTasks.length; i++)
		{
			organizedTasks[i] = new GenLL<Task>();
		}
	}
	
	public void addTasks(Task aTask)
	{
		int priority = aTask.getPriority();
		
		if(!organizedTasks[priority].contains(aTask))
		{
			organizedTasks[priority].add(aTask);
		}
		else
			System.out.println("Duplicate task exists. Task not added.");
		
	}
	
	public void removeTask(Task aTask)
	{
		int priority = aTask.getPriority();
		
		organizedTasks[priority].reset();
		
		while(organizedTasks[priority].hasMore())
		{
			if(organizedTasks[priority].getCurrent().equals(aTask))
			{
				organizedTasks[priority].removeCurrent();
				break;
			}
			organizedTasks[priority].gotoNext();
		}
	}
	
	public void printTasksConsole()
	{
		for(int i = 0; i < organizedTasks.length; i++)
		{
			organizedTasks[i].print();
		}
	}
	
	public void readTaskFile(String fileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			
			//reset all the lists
			for(int i = 0; i < organizedTasks.length; i++)
				organizedTasks[i].clearList();
			
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split("\t");
				
				if(splitLines.length == 2)
				{
					String action = splitLines[1];
					int priority = Integer.parseInt(splitLines[0]);
				
					Task newTask = new Task(priority, action);
					
					organizedTasks[priority].add(newTask);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//TODO: Figure out how to implement print without crashing computer
	
	public void printTaskFile(String newFileName)
	{
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(new File(newFileName)));
//			
//			for(int priority = 0; priority < organizedTasks.length; priority++)
//			{
//				
//			}
			for(int i = 0; i < 5; i++)
			{
				organizedTasks[i].reset();//resets to head on each list in array
				
				while(organizedTasks[i].getCurrent() != null)
				{
					Task tempTask = organizedTasks[i].getCurrent();
					fileWriter.println(tempTask.getPriority() + "\t" + tempTask.getAction());
					if(organizedTasks[i].hasMore())
						organizedTasks[i].gotoNext();
					else
						break;
				}
			}
			
			fileWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
