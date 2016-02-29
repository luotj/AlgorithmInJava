
public class LinkedQueueOfStrings {
	
	private Node first=null;
	private Node last=null;
	private int N=0;
	
	private class Node
	{
		String s;
		Node left;
		Node right;
	}
	
	public boolean isEmpty()
	{
		return N==0;
	}
	
	public void enqueue(String item)
	{
		Node node=new Node();
		node.s=item;
		node.left=null;
		node.right=null;
		if(N==0)
		{
			first=node;
			last=node;
		}
		else
		{
			Node oldfirst = first;
			oldfirst.left=node;
			node.right=oldfirst;
			first=node;
		}
		N++;
			
	}
	
	public String dequeue()
	{
		if(isEmpty())
			return null;
		if(N>0&&N==1)
		{
			N--;
			String item = last.s;
			first=null;
			last=null;
			return item;
		}
		else
		{
			N--;
			String item = last.s;
			Node newlast = last.left; 
			newlast.right=null;
			last=newlast;
			return item;
		}
	}
	
	public static void main(String[] args)
	{
		LinkedQueueOfStrings lq = new LinkedQueueOfStrings();
		lq.enqueue("hi");
		lq.enqueue("youyou");
		System.out.println(lq.dequeue());
		System.out.println(lq.dequeue());
	}

}
