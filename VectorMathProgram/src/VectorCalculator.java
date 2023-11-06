/*
 * Aarsh Patel
 */

//Packages
import java.util.Scanner;

public class VectorCalculator {

	//Initialize Input
	private static Scanner keyboard = new Scanner(System.in);
	
	//Main Method
	public static void main(String[] args) {
		
		//Title
		System.out.println("Vector Math Calculator");
		
		//Functions
		System.out.println("Welcome to the Vector Operations Program!");
		
		int[] action = new int[2];
		int funcChoice = 0;
		
		
		do {
			
			action = enterVecSize();
			funcChoice = action[0];
			int vecSize = action[1];
			
			//Check For Input Errors and apply methods
			switch(funcChoice) {
				case 1:
					addVec(vecSize);
					break;
				case 2:
					subVec(vecSize);
					break;
				case 3:
					magVec(vecSize);
					break;
				case 9:
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Invalid Input");
			}
		} while(funcChoice != 9);	
	}
		
	
	//Addition Vector
	public static boolean addVec(int vecSize) {
		
		//Create 1st and 2nd Vector
		double[] vector1 = new double[vecSize];
		System.out.println("Enter values for Vector 1");
		for(int i = 0; i < vecSize; i++) {
			vector1[i] = keyboard.nextDouble();
		}

		System.out.println("Enter values for Vector 2");
		double[] vector2 = new double[vecSize];
		for(int i = 0; i < vecSize; i++) {
			vector2[i] = keyboard.nextDouble();
		}
			
		//Add vectors and print final result
		double[] sumVecArray = new double[vecSize];
		System.out.println("Result:");
		for(int i = 0; i < vecSize; i++) {
			sumVecArray[i] = vector1[i] + vector2[i];
		}
	
		//Final result
		for(int i = 0; i < vector1.length; i++)
			System.out.println(vector1[i]);
		System.out.println("+");
		for(int i = 0; i < vector2.length; i++)
			System.out.println(vector2[i]);
		System.out.println("=");
		for(int i = 0; i < vector2.length; i++)
			System.out.println(sumVecArray[i]);
		
		return true;	//Shows as function is complete
	}

	//Subtracting Vectors
	public static boolean subVec(int vecSize) {
		
		//Create 1st and 2nd Vector
		double[] vector1 = new double[vecSize];
		System.out.println("Enter values for Vector 1");
		for(int i = 0; i < vecSize; i++) {
			vector1[i] = keyboard.nextDouble();
			keyboard.nextLine();
		}

		System.out.println("Enter values for Vector 2");
		double[] vector2 = new double[vecSize];
		for(int i = 0; i < vecSize; i++) {
			vector2[i] = keyboard.nextDouble();
			keyboard.nextLine();
		}
			
		//Add vectors and print final result
		double[] subVecArray = new double[vecSize];
		System.out.println("Result:");
		for(int i = 0; i < vecSize; i++) {
			subVecArray[i] = vector1[i] - vector2[i];
		}
	
		//Final result
		for(int i = 0; i < vector1.length; i++)
			System.out.println(vector1[i]);
		System.out.println("-");
		for(int i = 0; i < vector2.length; i++)
			System.out.println(vector2[i]);
		System.out.println("=");
		for(int i = 0; i < vector2.length; i++)
			System.out.println(subVecArray[i]);
		
		return true;	//Shows as function is complete
	}
	
	//Magnitude Vector
	public static boolean magVec(int vecSize) {
		
		//Create Vector
		double[] vector = new double[vecSize];
		System.out.println("Enter values for the Vector");
		for(int i = 0; i < vecSize; i++) {
			vector[i] = keyboard.nextDouble();
			keyboard.nextLine();
		}

		//Magnitude and Print
		System.out.println("Result:");
		double sumnum = 0;
		for(int i = 0; i < vecSize; i++) {
			sumnum += Math.pow(vector[i], 2);
		}
		double magnitude = Math.sqrt(sumnum);
		System.out.println("The magnitude is: " + magnitude);
		
		return true;
	}
	
	//Choices
	private static int chooseFunc() {
		System.out.println("Enter 1. To Add 2 Vectors");
		System.out.println("Enter 2. To Subtract 2 Vectors");
		System.out.println("Enter 3. To Find the Magnitude of a Vector");
		System.out.println("Enter 9. To Quit");
		int choice = keyboard.nextInt();
		
		return choice;
	}
	
	//Size of Vector
	private static int[] enterVecSize()
	{
		int vecSize = 0;
		int[] action = new int[2];
		
		do {
			//saves vector function value
			int funcChoice = 0;
			try {
				//while(funcChoice != 1 || funcChoice != 2 || funcChoice != 3 || funcChoice != 9) {
					funcChoice = chooseFunc();
					action[0] = funcChoice;
				//}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			//saves vector size value while checking for valid size
			if(funcChoice < 1 || funcChoice > 3)
				break;
			else {
				System.out.println("Enter the size of the Vectors");
				vecSize = keyboard.nextInt();
				keyboard.nextLine(); //Fix Bug
				action[1] = vecSize;
			}
			
		} while(vecSize == 0);
		
		return action;
	}
}
