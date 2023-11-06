/*
 * Aarsh Patel
 */

//Packages
import java.util.Scanner;
import java.io.*;

public class VideoGameFE {
	
	//Instances
	private VGList collection ;
	private VGList searchResults;
	private Scanner keyboard;
	
	
	//default contructor for front end
	public VideoGameFE()
	{
		collection = new VGList();
		searchResults = new VGList();
		keyboard = new Scanner(System.in);
	}

	//main method
	public static void main(String[] args) {
		
		//initialize front end and call front end method
		VideoGameFE frontEnd = new VideoGameFE();
		frontEnd.frontEnd();
	}
	
	public void frontEnd()
	{
		//Intro
		System.out.println("Welcome to the Video Game Database!");
		
		boolean quit = false;
		
		while(!quit) {
			printOptions();
			int choice = keyboard.nextInt();
			keyboard.nextLine();//fix bug
			
			switch(choice) {
				case 1:
					loadGameCollection();
					break;
				case 2:
					searchDatabase();
					break;
				case 3:
					printSearchList();
					break;
				case 4:
					writeSearchFile();
					break;
				case 0:
					quit = true;
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Invalid Input");
			}
		}
	}
	
	
	public void printOptions()
	{
		System.out.println("Enter 1 to load the video game database");
        System.out.println("Enter 2 to search the database");
        System.out.println("Enter 3 to print current results to the console");
        System.out.println("Enter 4 to print current results to file");
        System.out.println("Enter 0 to quit");
	}
	
	public void loadGameCollection()//Look for file and scan line by line
	{
		System.out.println("Enter the file name: ");
		String fileName = keyboard.nextLine();
		
		//load file
		try {
			
			Scanner fileScanner = new Scanner(new File(fileName));
			collection.clear();
			
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split("\t");
				if(splitLines.length == 2)
				{
					String title = splitLines[0];
					String console = splitLines[1];
					VideoGame aVG = new VideoGame(title, console);
					collection.add(aVG);
				}
			}
			
			System.out.println("Database Successful");
		}
		catch(Exception e)
		{
			System.out.println("Error");
			e.printStackTrace();;
		}
		
		
	}

	public void searchDatabase()//search collection and find eaither all or by name
	{
		System.out.print("Enter the name of the game or '*' for all: ");
        String title = keyboard.nextLine();
        System.out.print("Enter the name of the console or '*' for all: ");
        String console = keyboard.nextLine();
        
        searchResults.clear();
        
        for(int i = 0; i < collection.getSize(); i++)
        {
        	//Pulls data of each node
        	VideoGame aVG = collection.get(i);
        	String gameTitle = aVG.getTitle();
        	String gameConsole = aVG.getConsole();
        	
        	
        	boolean titleMatch = title.equals("*") || gameTitle.toLowerCase().contains(title.toLowerCase());
        	boolean consoleMatch = console.equals("*") || gameConsole.toLowerCase().contains(console.toLowerCase());
        	if((title.equals("*") && console.equals("*")) || (titleMatch && consoleMatch))
        	{
        		searchResults.add(aVG);
        	}
        	
        }
        
        if(searchResults.isEmpty())
        	System.out.println("No Games Found");
        else
        	System.out.println("Search Done");
	}
	
	public void printSearchList()//print searched linked list to console
	{
		if(searchResults.isEmpty())
		{
			System.out.println("No Games Found");
			return;
		}
		
		System.out.println("Search Results:");
		
		for(int i = 0; i < searchResults.getSize(); i++)
		{
			VideoGame aVG = searchResults.get(i);
			System.out.println(aVG.getTitle() + "\t" + aVG.getConsole());
		}
	}

	public void writeSearchFile()//write file with name input and put search list in it line by line.Allow for appending files.
	{
		System.out.println("Enter the file name: ");
		String fileName = keyboard.nextLine();
        System.out.print("Would you like to append? True or false: ");
        boolean append = keyboard.nextBoolean();
        keyboard.nextLine();
        
        try
        {
        	PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName, append));
        	for(int i = 0; i < searchResults.getSize(); i++)
        	{
        		VideoGame aVG = searchResults.get(i);
        		fileWriter.println(aVG.getTitle() + "\t" + aVG.getConsole());
        	}
        	
        	System.out.println("File Function Complete");
        }
        catch(Exception e)
        {
        	System.out.println("Error");
        	e.printStackTrace();
        }
	}
}
