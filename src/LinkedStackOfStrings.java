
public class LinkedStackOfStrings {
	private Node first = null;
	private class Node{
		String item;
		Node next;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public void push(String item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	
	public String pop(){
		String item = first.item;
		first=first.next;
		return item;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedStackOfStrings ls = new LinkedStackOfStrings();
		ls.push("hello");
		ls.push("world");
		while(!ls.isEmpty())
			System.out.println(ls.pop());
	}

}
