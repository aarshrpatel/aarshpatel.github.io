/*
 * Aarsh Patel
 */

//Packages
import java.util.Scanner;

public class SimulatorFE {
	
	
	private static Scanner keyboard = new Scanner(System.in);
	private static SimulatorManager sim = new SimulatorManager();
	
	public static void main(String[] args) {
		
		boolean quit = false;
		
		while(!quit)
		{
			//Reads board file and saves it in array of arrays
			String[][] board = readBoardFile();
			
			//Reads command file and saves it in linked list queue
			LLQueue<String> robotCommands = readRobotCommandFile();
			
			//Simulate Commands and run until quit is chosen
			
			sim.simulateCommands(board, robotCommands);
			
			System.out.println("Quit? Enter \"true\" to quit or \"false\" to run another simulation");
			quit = keyboard.nextBoolean();
			keyboard.nextLine();//fix bug
			
			
		}
	}
	
	public static String[][] readBoardFile()
	{
		System.out.println("Enter file name for the Board");
		String boardFileName = keyboard.nextLine();
		
		//Read Board File
		String[][] board = sim.readBoardFile(boardFileName);
		
		return board;
	}
	
	public static LLQueue<String> readRobotCommandFile()
	{
		System.out.println("Enter file name for the Robot Commands");
		String robotCommandFileName = keyboard.nextLine();
		
		//Read Command File
		LLQueue<String> robotCommands = sim.readRobotCommandFile(robotCommandFileName);
	
		return robotCommands;
	}
}
