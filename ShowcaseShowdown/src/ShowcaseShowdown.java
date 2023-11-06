/*
 * Aarsh Patel
 */

//Packages
import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class ShowcaseShowdown {
	//Initialize User Inputs and Random
	private static Scanner keyboard = new Scanner(System.in);
	private static Random rand = new Random();
	
	//Initialize variables
	private static int DEF_PRIZES = 5;
	private static String DELIM = "\t";
	private static Prize[] prizes = new Prize[countLines()];
	
	//Main Method
	public static void main(String[] args) {
		//Introduction
		System.out.println("Welcome to the Showcase Showdown!");
		
		boolean quit = false;
		do {
			//Call Prizes
			readFile();
			Prize[] randomPrizes = getRandomPrizes(prizes);
			printRandPrizes(randomPrizes);
			
			
			//Guess total price of prizes
			System.out.println("You must guess the total cost of the prizes\n"
					+ "without going over and within $1,300 of its actual price");
			
			System.out.println("Enter your guess");
			double userGuess = keyboard.nextDouble();
			keyboard.nextLine();
			
			//Print Actual Price
			double actualPrice = sumPrices(randomPrizes);
			System.out.format("The actual cost was $%.2f%n", actualPrice);
			
			//Check To see if they won
			boolean win = checkWinner(randomPrizes, userGuess);
			if(win)
			{
				System.out.println("You win!!!");
			}
			else
				System.out.println("You lose");
			
			//Ask to quit program
			System.out.println("Would you like to quit? Enter \"yes\" to quit");
			String quitChoice = keyboard.nextLine();
			
			if(quitChoice.equals("yes")) 
			{
				System.out.println("Goodbye!");
				quit = true;
			}
			else
				quit = false;
		
		} while(!quit);
		
	}
	
	//Read Prize File
	public static void readFile() 
	{
		try
		{
			Scanner fileScanner = new Scanner(new File("./prizeList.txt"));
			while(fileScanner.hasNext())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLine = fileLine.split(DELIM);
				if(splitLine.length == 2)
				{
					String name = splitLine[0];
					String priceString = splitLine[1];
					double price = Double.parseDouble(priceString);
				
					
					Prize aPrize = new Prize(name, price);
					addPrize(aPrize);
				}
			}
			
			fileScanner.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		 
	}
	
	private static int countLines()
	{
		int count = 0;
		try
		{
			Scanner fileScanner = new Scanner(new File("./prizeList.txt"));
			while(fileScanner.hasNext())
			{
				fileScanner.nextLine();
				count++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	private static void addPrize(Prize aPrize)
	{
		if(prizes[prizes.length - 1] != null)
		{
			return;
		}
		for(int i = 0; i < prizes.length; i++)
		{
			if(prizes[i] == null)
			{
				prizes[i] = aPrize;
				break;
			}
		}
	}
	
	//Select Random Prizes for Showcase
	
	public static Prize[] getRandomPrizes(Prize[] prizes)
	{
		Prize[] randomPrizes = new Prize[DEF_PRIZES];

		
		if(prizes.length < 5)
			return null;
		
		for(int i = 0; i < DEF_PRIZES; i++)
		{
			int randomIndex;
			
			//checks to see if index is null and if it is then calls random until it isn't
			do {
				randomIndex = rand.nextInt(prizes.length);
				
			} while(prizes[randomIndex] == null);
			
			//set prizes for showdown
			randomPrizes[i] = prizes[randomIndex];
			
			//Removes prize from choices so the same prize is not called again
			prizes[randomIndex] = null;
			
		}
		
		return randomPrizes;
	}
	
	//Print Random Prizes
	public static void printRandPrizes(Prize[] randomPrizes)
	{	
		System.out.println("Your prizes are: ");
		for(int i = 0; i < randomPrizes.length; i++)
		{
			System.out.println(randomPrizes[i].getName());
		}
	}
	
	//Determine if user won or lost
	public static boolean checkWinner(Prize[] randomPrizes, double userGuess)
	{
		
		double actualPrice = sumPrices(randomPrizes);
		
		double lowerBound = actualPrice - 1300;
		double upperBound = actualPrice;
		
		return userGuess >= lowerBound && userGuess <= upperBound;
		
	}
	
	public static double sumPrices(Prize[] randomPrizes)
	{
		double sum = 0;
		//add the value of all prizes
		for(Prize prize : randomPrizes)
		{
			sum += prize.getPrice();
		}
		
		return sum;
	}
}
