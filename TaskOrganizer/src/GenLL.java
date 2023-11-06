/*
 * Aarsh Patel
 */

//packages
import java.io.*;

public class GenLL<T> {
	protected class ListNode 
	{
		protected T data;
		protected ListNode link;
		
		public ListNode()
		{
			data = null;
			link = null;
		}
		
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
		
		public ListNode(T aData)
		{
			data = aData;
			link = null;
		}
	}
	
	private ListNode head;
	private ListNode current;
	private ListNode previous;
	
	public ListNode getHead()
	{
		if(head == null)
			return null;
		return this.head;
	}
	
	public GenLL()
	{
		head = current = previous = null;
	}
	
	public void add(T aData)
	{
		ListNode newNode = new ListNode(aData);
		
		if(head == null)
		{
			head = current = newNode;
			return;
		}
		ListNode temp = head;
		while(temp.link != null)
			temp = temp.link;
		temp.link = newNode;
	}
	
	public void print()
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	
	public void addAfterCurrent(T aData)
	{
		if(current != null)
		{
			ListNode newNode = new ListNode(aData, current.link);
			current.link = newNode;
		}
	}
	
	public T getCurrent()
	{
		if(current != null)
			return current.data;
		else
			return null;
	}
	
	public void setCurrent(T aData)
	{
		if(aData == null || current == null)
			return;
		current.data = aData;
	}
	
	public void gotoNext()
	{
		
		if(current.link == null)
			return;
		previous = current;
		current = current.link;
	}
	
	public void reset()
	{
		current = head;
		previous = null;
	}
	
	public boolean hasMore()
	{
		return current.link != null;
	}
	
	public void removeCurrent()
	{
		if(current == head)
		{
			head = head.link;
			current = head;
		}
		else
		{
			previous.link = current.link;
			current = current.link;
		}
	}
	
	public boolean contains(T aData)
	{
		ListNode temp = head;
		
		while(temp != null)
		{
			if(temp.data == aData)
				return true;
			temp = temp.link;
		}
		
		return false;
	}
	
	public void clearList()
	{
		head = current = previous = null;
	}

}
