//Aarsh Patel

//imports
import java.util.Scanner;

public class PBJFrontEnd {

	public static void main(String[] args) {
		//initialize keyboard
				Scanner keyboard = new Scanner(System.in);
				
		//Put this in a do-while loop to allow the user to run as many times as they want
		String userChoice = "Restart";
		do {
			//Variables
			String dashedLine = "---------------------------------";
			
			//Title
			System.out.println(dashedLine);
			System.out.println("Welcome to the PB & J Sandwich Maker!");
			System.out.println(dashedLine);
			
			
			
			//Create Sandwich 1
			System.out.println("-----Sandwich 1-----");
			PBJSandwich sandwich1 = createSandwich(keyboard);
			
			//Create Sandwich 2
			System.out.println(dashedLine);
			System.out.println("-----Sandwich 2-----");
			PBJSandwich sandwich2 = createSandwich(keyboard);
			
			//Print the two sandwiches
				//Sandwich 1
			System.out.println(dashedLine);
			System.out.println("-----Sandwich 1-----");
			System.out.println(sandwich1);
			
				//Sandwich 2
			System.out.println(dashedLine);
			System.out.println("-----Sandwich 2-----");
			System.out.println(sandwich2);
			
			System.out.println();
			System.out.println(dashedLine);
			System.out.println();
			
			//Check to see if the two sandwiches are the same
			if (sandwich1.equals(sandwich2))
				System.out.println("These two sandwiches are the same");
			else
				System.out.println("These two sandwiches are different");
			
			//Ask user if they want to restart or quit program
			System.out.println();
			System.out.println(dashedLine);
			System.out.println("Would you like to restart or quit the program?"
					+ " (Type 'restart' or 'quit')");
			userChoice = keyboard.nextLine();
			
			if (userChoice.equalsIgnoreCase("Restart"))
				continue;
			else if (userChoice.equalsIgnoreCase("Quit"))
				System.out.println("Program Terminated.");
			else
				System.out.println("Invalid Input. Program terminated.");
			
		} while(userChoice.equalsIgnoreCase("Restart"));
		

	}
	
	public static PBJSandwich createSandwich(Scanner keyboard) {
		
		//Top Slice
		System.out.println("Top Slice of Bread Information");
		Bread topBread = createBread(keyboard);
		
		//Peanut Butter
		System.out.println("Peanut Butter Information");
		PeanutButter peanutButter = createPeanutButter(keyboard);
		
		//Jelly
		System.out.println("Jelly Information");
		Jelly jelly = createJelly(keyboard);
		
		//Bottom Slice
		System.out.println("Bottom Slice of Bread Information");
		Bread bottomBread = createBread(keyboard);
		
		return new PBJSandwich(topBread, peanutButter, jelly, bottomBread);
		
		//Bottom Slice
	} //createSandwich end
	
	public static Bread createBread(Scanner keyboard) {
		//Name
		System.out.println("Enter name of the bread: ");
		String breadName = keyboard.nextLine();
		
		//Calories
		System.out.println("Enter the number of calories: ");
		int breadCalories = keyboard.nextInt();
		
		//Bread Type
		System.out.println("Enter the type of bread from this list: \n"
				+ "'Honey Wheat', 'White', 'Whole Grain', or 'Whole Wheat'");
		keyboard.nextLine(); //fixes the bug and allows for the next line of code to run properly
		String breadType = keyboard.nextLine();
		//System.out.println(breadType);	//debugging the system bug
		
		return new Bread(breadName, breadCalories, breadType);
	}

	public static PeanutButter createPeanutButter(Scanner keyboard) {
		//name
		System.out.println("Enter the name of the peanut butter brand: ");
		String brandNamePB = keyboard.nextLine();
		
		//calories
		System.out.println("Enter the number of calories: ");
		int caloriesPB = keyboard.nextInt();
		
		//Crunchy?
		System.out.println("Is it crunchy? Enter \"true\", or \"false\": ");
		boolean isCrunchy = keyboard.nextBoolean();
		
		return new PeanutButter(brandNamePB, caloriesPB, isCrunchy);
	} //createPeanutButter end
	
	public static Jelly createJelly(Scanner keyboard) {
		//name
		System.out.println("Enter the brand name of the Jelly: ");
		keyboard.nextLine(); //fixes the bug for inputting from the user
		String jellyBrandName = keyboard.nextLine();
		
		//calories
		System.out.println("Enter the number of calories: ");
		int jellyCalories = keyboard.nextInt();
		
		//type
		System.out.println("Enter the type of Jelly from these options: "
				+ "'Apple', 'Blueberry', 'Grape', 'Strawberry', or 'Tomato'");
		keyboard.nextLine();
		String jellyType = keyboard.nextLine();
		
		return new Jelly(jellyBrandName, jellyCalories, jellyType);
	}
}
