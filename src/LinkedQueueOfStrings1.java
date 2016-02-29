
public class LinkedQueueOfStrings1 {
	private Node first = null;
	private Node last = null;
	
	private class Node
	{
		String s;
		Node next;
	}
	
	public boolean isEmpty()
	{
		return first==null;
	}
	
	public void enqueue(String item)
	{
		Node oldlast = last;
		last=new Node();
		last.s=item;
		last.next=null;
		if(first==null)
			first=last;
		else
			oldlast.next=last;
	}
	
	public String dequeue()
	{
		String item = first.s;
		first=first.next;
		if(isEmpty()) last=null;
		return item;
		
	}
	
	public static void main(String [] args)
	{
		LinkedQueueOfStrings1 lq = new LinkedQueueOfStrings1();
		lq.enqueue("hi");
		lq.enqueue("youyou");
		System.out.println(lq.dequeue());
		System.out.println(lq.dequeue());
	}
}
