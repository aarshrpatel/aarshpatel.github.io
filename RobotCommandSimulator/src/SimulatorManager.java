/*
 * Aarsh Patel
 */

//Packages
import java.util.Scanner;
import java.io.*;

public class SimulatorManager {
	private final int BOARD_ROWS = 10;
	private final int BOARD_COLMNS = 10;
	private LLQueue<String> robotCommands = new LLQueue<String>();
	private final String UP = "Move Up";
	private final String DOWN = "Move Down";
	private final String RIGHT = "Move Right";
	private final String LEFT = "Move Left";
	
	
	public String[][] readBoardFile(String boardFileName)
	{
		String[][] board = new String[BOARD_ROWS][BOARD_COLMNS];
		
		try
		{
			Scanner fileScanner = new Scanner(new File(boardFileName)); 
			
			for(int line = 0; line < BOARD_ROWS; line++)
			{
				String boardLine = fileScanner.nextLine();
				String[] splitLine = boardLine.split("");
				
				for(int i = 0; i < BOARD_COLMNS; i++)
				{
					board[line][i] = splitLine[i];
				}
			}		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return board;
	}

	public LLQueue<String> readRobotCommandFile(String robotCommandFileName)
	{
		try
		{	
			robotCommands.reset();
			Scanner fileScanner = new Scanner(new File(robotCommandFileName));
			
			while(fileScanner.hasNextLine())//Checks every line until the end
			{
				String command = fileScanner.nextLine();//pulls the command from each line
				robotCommands.enqueue(command);//adds it to the end of the queue
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return robotCommands;
	}
	
	public void simulateCommands(String[][] board, LLQueue<String> robotCommands)
	{
		int x = 0;
		int y = 0;
		//Print the board without running commands
		board[y][x] = "O";
		printBoard(board);
		
		System.out.println("Simulation begin");
		
		//perform the functions
		int size = robotCommands.getSize();
		
		for(int i = 0; i < size; i++)//need to find how to loop through each command in queue
		{
			System.out.println();
			System.out.println("Command " + i);
			String command = robotCommands.dequeue();//pulls command at the head out
			boolean crash = false;
			
			switch(command) {
			case RIGHT:
				if(board[y][x + 1].equals("X") || board[y][x + 1].equals(null))
				{
					System.out.println("CRASH!");
					crash = true;
					break;
				}
				else
				{
					board[y][x] = "_";
					board[y][x + 1] = "O";
					x += 1;
					printBoard(board);
				}
				break;
				
			case LEFT:
				if(board[y][x - 1].equals("X") || board[y][x - 1].equals(null))
				{
					System.out.println("CRASH!");
					break;
				}
				else
				{
					board[y][x] = "_";
					board[y][x - 1] = "O";
					x -= 1;
					printBoard(board);
				}
				break;
				
			case UP:
				if(board[y - 1][x].equals("X") || board[y - 1][x].equals(null))
				{
					System.out.println("CRASH!");
					break;
				}
				else
				{
					board[y][x] = "_";
					board[y - 1][x] = "O";
					y -= 1;
					printBoard(board);
				}
				break;
				
			case DOWN:
				if(board[y + 1][x].equals("X") || board[y + 1][x].equals(null))
				{
					System.out.println("CRASH!");
					break;
				}
				else
				{
					board[y][x] = "_";
					board[y + 1][x] = "O";
					y += 1;
					printBoard(board);
				}
				break;
			}
			if(crash)
				break;//if the command crashes, then the for loop stops
		}
		
		if(y == BOARD_ROWS - 1 && x == BOARD_COLMNS - 1)
			board[y][x] = "_";
		
		System.out.println("Simulation end");
	}
	
	public void printBoard(String[][] board)
	{
		for(int line = 0; line < BOARD_ROWS; line++)//every row
		{
			for(int i = 0; i < BOARD_COLMNS; i++)//each character in each line
			{
				System.out.print(board[line][i]);
			}
			
			System.out.println();
		}
	}
}
