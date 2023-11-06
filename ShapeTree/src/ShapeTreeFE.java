/*
 * Aarsh Patel
 */

//Packages
import java.util.Scanner;
import java.io.*;

public class ShapeTreeFE {
	private static Scanner keyboard = new Scanner(System.in);
	private static LinkedBST<Shape> shapeTree = new LinkedBST<Shape>();
	
	public static void main(String[] args) {
		
		//Introduction
		System.out.println("Welcome to the Shape Tree!");
		
		
		
		//Run Program for Option Chosen
		boolean quit = false;
		while(!quit)
			quit = runProgram(quit);
	}
	
	public static void printOptions()
	{
		println("Enter 1. To read a Shape Tree from a File.");
		println("Enter 2. To print a Tree Traversal to the Console");
		println("Enter 3. To Add a Shape.");
		println("Enter 4. To Remove a Shape.");
		println("Enter 5. To Search for a Shape.");
		println("Enter 6. To Find the Shape with the Max Area.");
		println("Enter 7. To Remove All Shapes Greater than an Area.");
		println("Enter 8. To Print Shape Tree to File.");
		println("Enter 0. To Quit.");
	}
	
	public static boolean runProgram(boolean quit)
	{
		//Options
		printOptions();
		int optionsChoice = keyboard.nextInt();
		keyboard.nextLine();//Fix Bug
		
		//run options
		switch(optionsChoice)
		{
			case 1:
				readTreeFile();
				println();
				break;
			case 2:
				printTreeTraversal();
				println();
				break;
			case 3:
				addShape();
				println();
				break;
			case 4:
				removeShape();
				println();
				break;
			case 5:
				searchForShape();
				println();
				break;
			case 6:
				maxAreaShape();
				println();
				break;
			case 7:
				removeShapesGreaterThan();
				break;
			case 8:
				
				break;
			case 0:
				quit = true;
				break;
			default:
				
		}
		return quit;
	}
	
	public static void readTreeFile()
	{
		println("Enter the file's name");
		String fileName = keyboard.nextLine();
		
		//read file
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			
			while(fileScanner.hasNextLine())
			{
				String line = fileScanner.nextLine();
				String[] splitLine = line.split("\t");
				String type = splitLine[0];
				if(splitLine.length == 2 && type.equalsIgnoreCase("circle"))
				{
					
					double radius = Double.parseDouble(splitLine[1]);
					shapeTree.add(new Circle(radius));
				}
				else if(splitLine.length == 3)
				{
					if(type.equalsIgnoreCase("rectangle"))
					{
						double length = Double.parseDouble(splitLine[1]);
						double width = Double.parseDouble(splitLine[2]);
						shapeTree.add(new Rectangle(length, width));
					}
					else if(type.equalsIgnoreCase("right triangle"))
					{
						double base = Double.parseDouble(splitLine[1]);
						double height = Double.parseDouble(splitLine[2]);
						shapeTree.add(new RightTriangle(base, height));
					}
				}
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//Print File
		println("Printing after Reading In-Order");
		shapeTree.printInOrder();
	}
	
	public static void printTreeTraversal()
	{
		//options
		println("Which traversal?");
		println("Enter 1. For Pre-order.");
		println("Enter 2. For In-order");
		println("Enter 3. For Post-order");
		int orderChoice = keyboard.nextInt();
		keyboard.nextLine();//fix bug
		
		//run choice
		switch(orderChoice)
		{
		case 1:
			shapeTree.printPreorder();
			break;
		case 2:
			shapeTree.printInOrder();
			break;
		case 3:
			shapeTree.printPostOrder();
			break;
		default:
			println("Invalid Input");
		}
	}
	
	public static void addShape()
	{
		println("Enter the type of shape to add");
		String shapeType = keyboard.nextLine();
		
		switch(shapeType.toLowerCase())
		{
		case "circle":
			println("Enter the radius of the Circle");
			double radius = keyboard.nextDouble();
			keyboard.nextLine();//fix bug
			shapeTree.add(new Circle(radius));
			break;
			
		case "rectangle":
			//Ask for length
			println("Enter the length of the Rectangle");
			double length = keyboard.nextDouble();
			keyboard.nextLine();//fix bug
			//Ask for width
			println("Enter the width of the Rectangle");
			double width = keyboard.nextDouble();
			keyboard.nextLine();
			shapeTree.add(new Rectangle(length, width));
			break;
			
		case "right triangle":
			println("Enter the base of the Right Triangle");
			double base = keyboard.nextDouble();
			keyboard.nextLine();//fix bug
			//Ask for width
			println("Enter the height of the Right Triangle");
			double height = keyboard.nextDouble();
			keyboard.nextLine();
			shapeTree.add(new RightTriangle(base, height));
			break;
			
		default:
			println("Invalid type");
		}
	}
	
	public static void removeShape()
	{
		println("Enter the type of shape to remove");
		String shapeType = keyboard.nextLine();
		
		switch(shapeType.toLowerCase())
		{
		case "circle":
			println("Enter the radius of the Circle");
			double radius = keyboard.nextDouble();
			keyboard.nextLine();//fix bug
			shapeTree.remove(new Circle(radius));
			break;
			
		case "rectangle":
			//Ask for length
			println("Enter the length of the Rectangle");
			double length = keyboard.nextDouble();
			keyboard.nextLine();//fix bug
			//Ask for width
			println("Enter the width of the Rectangle");
			double width = keyboard.nextDouble();
			keyboard.nextLine();
			shapeTree.remove(new Rectangle(length, width));
			break;
			
		case "right triangle":
			println("Enter the base of the Right Triangle");
			double base = keyboard.nextDouble();
			keyboard.nextLine();//fix bug
			//Ask for width
			println("Enter the height of the Right Triangle");
			double height = keyboard.nextDouble();
			keyboard.nextLine();
			shapeTree.remove(new RightTriangle(base, height));
			break;
			
		default:
			println("Invalid type");
		}
		
	}

	public static void searchForShape()
	{
		println("Enter the type of shape to Search");
		String shapeType = keyboard.nextLine();
		boolean shapeFound = false;
		
		switch(shapeType.toLowerCase())
		{
		case "circle":
			println("Enter the radius of the Circle");
			double radius = keyboard.nextDouble();
			keyboard.nextLine();//fix bug
			shapeFound = shapeTree.search(new Circle(radius));
			break;
			
		case "rectangle":
			//Ask for length
			println("Enter the length of the Rectangle");
			double length = keyboard.nextDouble();
			keyboard.nextLine();//fix bug
			//Ask for width
			println("Enter the width of the Rectangle");
			double width = keyboard.nextDouble();
			keyboard.nextLine();
			shapeFound = shapeTree.search(new Rectangle(length, width));
			break;
			
		case "right triangle":
			println("Enter the base of the Right Triangle");
			double base = keyboard.nextDouble();
			keyboard.nextLine();//fix bug
			//Ask for width
			println("Enter the height of the Right Triangle");
			double height = keyboard.nextDouble();
			keyboard.nextLine();
			shapeFound = shapeTree.search(new RightTriangle(base, height));
			break;
			
		default:
			println("Invalid type");
		}
		
		println("Was the shape in the tree? " + shapeFound);
	}

	public static void maxAreaShape()
	{
		println("The shape with the max area " + shapeTree.findMaxInTree());
	}
	
	public static void removeShapesGreaterThan()//TODO fix
	{
		println("Enter the maximum area");
		double maxArea = keyboard.nextDouble();
		keyboard.nextLine();//fix bug
		
		
	}
	
	public static void printTreeToFile()
	{
		println("Enter the file's name");
		String fileName = keyboard.nextLine();
		
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName));
			
			fileWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	
	
	
	
	
	
	//General Functions that make it easier to code
	private static void println(String aData)
	{
		System.out.println(aData);
	}
	private static void println(int aData)
	{
		System.out.println(aData);
	}
	private static void println(boolean aData)
	{
		System.out.println(aData);
	}
	private static void println(Shape aData)
	{
		System.out.println(aData);
	}
	private static void println()
	{
		System.out.println();
	}
}
