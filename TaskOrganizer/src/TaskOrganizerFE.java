/*
 * Aarsh Patel
 */

//Packages
import java.util.Scanner;

public class TaskOrganizerFE {
	
	private static TaskList taskList = new TaskList();
	private static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Introduction
		System.out.println("Welcome to the Task Organizer!");
		
		int userChoice; 
		boolean quit = false;
		
		while(!quit)
		{
			userChoices();
			userChoice = keyboard.nextInt();
			keyboard.nextLine();//fix bug
			
			switch(userChoice)
			{
			case 1:
				addTask();
				break;
			case 2:
				removeTask();
				break;
			case 3:
				printConsole();
				break;
			case 4:
				readFile();
				break;
			case 5:
				writeFile();
				break;
			case 9:
				System.out.println("Goodbye!");
				quit = true;
				break;
			default:
				System.out.println("Invalid Input. Please Try Again!");
			}
			
		}
	}
	
	public static void addTask()
	{
		System.out.println("Enter the task's priority");
		int priority = keyboard.nextInt();
		keyboard.nextLine();//fix bug
		
		System.out.println("Enter the task's action");
		String action = keyboard.nextLine();
		
		Task newTask = new Task(priority, action);
		
		taskList.addTasks(newTask);
	}

	public static void removeTask()//Debug to find why it doesnt work
	{
		System.out.println("Enter the task's priority");
		int priority = keyboard.nextInt();
		keyboard.nextLine();
		
		System.out.println("Enter the task's action");
		String action = keyboard.nextLine();
		
		Task newTask = new Task(priority, action);
		taskList.removeTask(newTask);
		
		System.out.println("Task Removed");
	}
	
	
	public static void printConsole()
	{
		taskList.printTasksConsole();
	}
	
	public static void readFile()
	{
		System.out.println("Enter the file name");
		String fileName = keyboard.nextLine();
		
		taskList.readTaskFile(fileName);
	}
	
	public static void writeFile()
	{
		System.out.println("Enter the file name");
		String fileName = keyboard.nextLine();
		
		taskList.printTaskFile(fileName);
	}
	
	public static void userChoices()
	{
		//Choices
		System.out.println("Enter 1. To Add a Task");
		System.out.println("Enter 2. To Remove a Task");
		System.out.println("Enter 3. To Print Tasks to Console");
		System.out.println("Enter 4. To Read from a Task File");
		System.out.println("Enter 5. To Write to a Task File");
		System.out.println("Enter 9. To Quit");
	}
}









