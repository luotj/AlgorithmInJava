
public class ResizingArrayStackOfStrings {

	private String[] s = new String[1];
	private int N=0;
	
	public boolean isEmpty()
	{
		return N==0;
	}
	
	public void push(String item)
	{
		if(N==s.length) resize(2*s.length);
		s[N++]=item;
	}
	
	public String pop()
	{
		if(isEmpty())
			return null;
		String item = s[--N];
		s[N] = null;
		if(N > 0 && N == s.length/4) resize(s.length/2);
		return item;
		
	}
	private void resize(int size)
	{
		String[] copy = new String[size];
		for(int i=0;i<s.length;i++)
			copy[i]=s[i];
		s=copy;
	}
	
	public static void main(String[] args)
	{
		ResizingArrayStackOfStrings rs = new ResizingArrayStackOfStrings();
		rs.push("hi");
		rs.push("youyou!");
		System.out.println(rs.pop());
		System.out.println(rs.pop());
	}
}
