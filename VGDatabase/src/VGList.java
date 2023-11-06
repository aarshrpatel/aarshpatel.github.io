/*
 * Aarsh Patel
 */
public class VGList {
	//ListNode class
	protected class ListNode
	{
		//Instances for ListNode
		protected VideoGame data;
		protected ListNode link;
		
		//Constructor
		public ListNode(VideoGame aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	
	//VGList instances
	private ListNode head;
	private ListNode current;
	private ListNode previous;
	private int size;
	
	//Constructor
	public VGList()
	{
		head = null;
		current = null;
		previous = null;
		size = 0;
	}
	
	public int getSize()//Gets size of List
	{
		return size;
	}
	
	public boolean isEmpty()//Checks to see if List is empty
	{
		if(size == 0)
			return true;
		else 
			return false;
	}
	
	public void add(VideoGame aVideoGame)
	{
		ListNode newNode = new ListNode(aVideoGame, null);
		
		if(isEmpty())
		{
			head = current = newNode;
		}
		else
		{
			current = head;
			while(current.link != null)
			{	
				previous = current;
				current = current.link;
			}
			current.link = newNode;
		}
		
		size++;//adds 1 to size 
	}
	
	public VideoGame get(int index)
	{
		if(index < 0 || index >= size)
		{
			return null;
		}
		
		current = head;
		
		for(int i = 0; i < index; i++)
		{
			current = current.link;
		}
		
		return current.data;
	}
	
	public boolean contains(VideoGame aVideoGame)
	{
		current = head;
		while(current != null)
		{
			if(current.data.equals(aVideoGame))
				return true;
			
			current = current.link;
			
		}
		
		return false;
	}
	
	public void clear()
	{
		head = null;
		size = 0;
	}
	
	
}
