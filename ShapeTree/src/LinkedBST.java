/*
 * Aarsh Patel
 */

public class LinkedBST <Shape extends Comparable <Shape>>
{
	private class Node 
	{
		Shape shape;
		Node leftChild;
		Node rightChild;
		
		//Constructor
		public Node(Shape aShape)
		{
			shape = aShape;
			leftChild = rightChild = null;
		}
	}
	
	private Node root;
	
	public LinkedBST()
	{
		root = null;
	}
	
	public void add(Shape aShape)
	{
		if(root == null)//if root is empty then set to root
			root = new Node(aShape);
		else
			add(root, aShape);//add to end where it belongs
	}
	private Node add(Node aNode, Shape aShape)
	{
		if(aNode == null)
			aNode = new Node(aShape);
		
		else if(aShape.compareTo(aNode.shape)<0)
			aNode.leftChild = add(aNode.leftChild, aShape);
		
		else if(aShape.compareTo(aNode.shape) > 0)
			aNode.rightChild = add(aNode.rightChild, aShape);

		return aNode;
	}
	
	public void remove(Shape aData)
	{
		root = remove(root, aData);//calls recursion
	}
	private Node remove(Node aNode, Shape aData)
	{
		//Find the node
		if(aNode == null)//if at the leaf
			return null;
		else if(aData.compareTo(aNode.shape)<0)
			aNode.leftChild = remove(aNode.leftChild, aData);
		else if(aData.compareTo(aNode.shape)>0)
			aNode.rightChild = remove(aNode.rightChild, aData);
		else//Found
		{
			if(aNode.rightChild == null)
				return aNode.leftChild;
			else if(aNode.leftChild == null)
				return aNode.rightChild;
			Node temp = findMinInTree(aNode.rightChild);
			aNode.shape = temp.shape;
			aNode.rightChild = remove(aNode.rightChild, temp.shape);
		}
		return aNode;
	}
	private Node findMinInTree(Node aNode)
	{
		if(aNode == null)
			return null;
		else if(aNode.leftChild == null)
			return aNode;
		else 
			return findMinInTree(aNode.leftChild);
	}
	
	public void removeGreaterThanMaxArea(double area)
	{
		root = removeGreaterThanMaxArea(root, area);
	}
	private Node removeGreaterThanMaxArea(Node aNode, double maxArea)
	{
		//Find the first value greater than the max area
		if(aNode == null)//if at a leaf
			return null;
		
		aNode.rightChild = removeGreaterThanMaxArea(aNode.rightChild, maxArea);
		
//		if(aNode.shape.compareTo() > maxArea)
			
		return aNode;//TODO fix this method
	}

	public Shape findMaxInTree()
	{
		return findMaxInTree(root).shape;
	}
	private Node findMaxInTree(Node aNode)
	{
		if(aNode == null)
			return null;
		else if(aNode.rightChild == null)
			return aNode;
		else
			return findMaxInTree(aNode.rightChild);
	}
	
	public boolean search(Shape aData)
	{
		return search(root, aData);
	}
	
	private boolean search(Node aNode, Shape aData)//recursion
	{
		if(aNode == null)//Checks to see if Node is a leaf
			return false;
		else if(aData.compareTo(aNode.shape)<0)//GO LEFT
			return search(aNode.leftChild, aData);
		else if(aData.compareTo(aNode.shape)>0)//GO RIGHT
			return search(aNode.rightChild, aData);
		else
			return true;//shape is equal and found
	}
	
	public void printPreorder()
	{
		printPreorder(root);
	}
	private void printPreorder(Node aNode)//recursion
	{
		if(aNode == null)
			return;
		System.out.println(aNode.shape);//PROCESS
		printPreorder(aNode.leftChild);//LEFT
		printPreorder(aNode.rightChild);//RIGHT
	}
	
	public void printInOrder()
	{
		printInOrder(root);
	}
	private void printInOrder(Node aNode)//recursion
	{
		if(aNode == null)
			return;
		printInOrder(aNode.leftChild);//LEFT
		System.out.println(aNode.shape);//PROCESS
		printInOrder(aNode.rightChild);//RIGHT
	}
	
	public void printPostOrder()
	{
		printPostOrder(root);//call recursion
	}
	private void printPostOrder(Node aNode)//recursion
	{
		if(aNode == null)
			return;
		printPostOrder(aNode.leftChild);//LEFT
		printPostOrder(aNode.rightChild);//RIGHT
		System.out.println(aNode.shape);//PROCESS
	}
	
}
