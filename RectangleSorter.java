/**
 * 
 * @author Aarsh Patel
 *
 */

//imports
import java.util.Scanner;

public class RectangleSorter {
	//properties
	private static int size;
	private static Rectangle[] rectangles;
	
	
	
	
	//methods
	public static void main(String[] args) {
		//import keyboard
		Scanner keyboard = new Scanner(System.in);
		
		boolean stop = false;
		
		while(!stop) {
			
			//Present options to user
			System.out.println("RectangleSorter");
			System.out.println();
			System.out.println("Please choose an action from below:");
			System.out.println("1.) Enter Rectangle Data");
			System.out.println("2.) Sort and display the Rectangles’ areas from Smallest to Largest");
			System.out.println("3.) Sort and display the Rectangles’ areas form Largest to Smallest");
			System.out.println("4.) Display the Average Area of the rectangles");
			System.out.println("5.) Display the Minimum Area in the collection");
			System.out.println("6.) Display the Maximum Area in the collection");
			System.out.println("7.) Quit the program");
			System.out.println();
			System.out.println("Please Enter The Number Here: ");
			int userchoice = keyboard.nextInt();
			
			//TODO:If the user picks an invalid option, then the program must inform the user and continue.
			
			switch (userchoice)	{
				case 1:
					EnterRectangleData(keyboard);
					break;

				case 2:
					boolean ascending = true;
					if(CheckArrayExists()) {
						SortAndDisplayAreas(ascending);
					}
					break;
					
				case 3:
					if(CheckArrayExists()) {
						ascending = false;
						SortAndDisplayAreas(ascending);
					}
					break;
					
				case 4:
					if(CheckArrayExists())
						DisplayAverageArea();
					break;
					
				case 5:
					if(CheckArrayExists()) {
						ascending = true;
						DisplayMinAndMaxArea(ascending);
					}
					break;
					
				case 6:
					if(CheckArrayExists()) {
						ascending = false;
						DisplayMinAndMaxArea(ascending);
					}
					break;
					
				case 7:
					System.out.println();
					System.out.println("Thank You For Using The Rectangle Sorter");
					System.out.println("Good Bye!");
					stop = true;
					break;
					
				default:
					System.out.println("Invalid Input. Please Try Again.\n");
			}
		}
	}
	
	private static boolean EnterRectangleData(Scanner keyboard) {
		
		System.out.println("Enter the size of the collection: ");
		size = keyboard.nextInt();
		rectangles = new Rectangle[size];
		
		//TODO: if size inputted is valid continue if not then keep asking for valid input
			
		//ask for length and width for each spot in the array rectangle
		for (int i = 0; i < size; i++) {
			System.out.format("Rectangle %d%n", i + 1);
			System.out.println("Please enter the length here: ");
			double length = keyboard.nextDouble();
			System.out.println("Please enter the width here: ");
			double width = keyboard.nextDouble();
			
			rectangles[i] = new Rectangle(length, width);
		}
		return true;	//success
	}
	private static boolean SortAndDisplayAreas(boolean ascending) {
		SortRectangles(ascending);
		if (ascending) {
			System.out.println("Sorting Rectangle Areas from Smallest to Largest: ");
		}else {
			System.out.println("Sorting Rectangle Area from Largest to Smallest: ");
		}
		for (int i = 0; i < rectangles.length; i++) {
			System.out.println("Area: " + rectangles[i].getArea());
		}
		return true;
		
	}
	private static boolean SortRectangles(boolean ascending) {
		
//		//check to see if there is anything in the array
//		if (rectangles == null) {
//			System.out.println("List is empty. Can not be sorted");
//			return false;	//Sort Failed due to no array
//		}
//		
		//Sort the areas ascending
		if (ascending) {
			for (int i = 0; i < rectangles.length; i++) {
				for (int j = 0; j < rectangles.length - 1; j++) {
					if (rectangles[j].getArea() > rectangles[j + 1].getArea()) {
						Rectangle temp = rectangles[j];
						rectangles[j] = rectangles[j + 1];
						rectangles[j + 1] = temp;
					} 
				}
			}
			/*	Debugging purpose to see if sort works
			for (int i = 0; i < rectangles.length; i++) {
				System.out.println(rectangles[i].getArea());
			}
			*/
			return true;	//Success: sort completed
		}else {
			for (int i = 0; i < rectangles.length; i++) {
				for (int j = 0; j < rectangles.length - 1; j++) {
					if (rectangles[j].getArea() < rectangles[j + 1].getArea()) {
						Rectangle temp = rectangles[j + 1];
						rectangles[j + 1] = rectangles[j];
						rectangles[j] = temp;
					}
				}
			}
			/*	Debugging purpose to see if sort works
			for (int i = 0; i < rectangles.length; i++) {
				System.out.println(rectangles[i].getArea());
			}
			*/
			return true;	//Success: sort completed
		}
		
	}
	private static boolean DisplayAverageArea() {
		
		//find the sum off all the areas
		double sumArea = 0;
		for (int i = 0; i < rectangles.length; i++) {
			sumArea += rectangles[i].getArea();
		}
		//Find the average area of all the areas
		double averageArea = sumArea / rectangles.length;
		
		System.out.format("Average Area: %f%n", averageArea);
		System.out.println();
		return true;	//success
	}
	private static boolean DisplayMinAndMaxArea(boolean ascending) {
		SortRectangles(ascending);
		if(ascending) {
			System.out.println("Minimun Area: " + rectangles[0].getArea());
		} else {
			System.out.println("Maximum Area: " + rectangles[0].getArea());
		}
		return true;	//success
	}
	private static boolean CheckArrayExists() {
		if (rectangles == null) {
            System.out.println("Array is empty. Please enter rectangle data first\n");
            return false;	//success: Array does not exist
		} else {
			return true;
		}
	}
}


