/*
 * Aarsh Patel
 */
public interface Queue <T> {
	public void enqueue(T aData);//Add to tail (end)
	public T dequeue();//Remove and return head
	public T peek();//Observes head but does not remove
	public void print();//prints
}
