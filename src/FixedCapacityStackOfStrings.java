
public class FixedCapacityStackOfStrings {
	private String[] s;
	private int N = 0;
	
	public FixedCapacityStackOfStrings(int capacity)
	{
		s=new String[capacity];
	}
	
	public boolean isEmpty()
	{
		return N==0;
	}
	
	public void push(String item)
	{
		s[N++] = item;
	}
	
	public String pop()
	{
		String item = s[--N];
		s[N]=null;//如此内存效率更高
		return item;
	}
	
	public static void main(String [] args)
	{
		FixedCapacityStackOfStrings fs = new FixedCapacityStackOfStrings(5);
		fs.push("Hi");
		fs.push("youyou");
		while(!fs.isEmpty())
			System.out.println(fs.pop());
	}
}
