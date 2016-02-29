import java.util.Stack;

/*
 * 实现常数时间复杂度实现min栈
 * 实现思路：用一个栈来存储数据，用另一个栈来存储当前栈的最小值
 */
public class MinStack {

	Stack<Integer> dataStack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	public int min() {
		return minStack.peek();
	}
	
	public void push(int data) {

		if(dataStack.isEmpty()) {
			dataStack.push(data);
			minStack.push(data);
		}
		else {
			dataStack.push(data);
			if(data < minStack.peek()) {
				minStack.push(data);
			}
			else {
				minStack.push(minStack.peek());
			}
		}
	}
	
	public Integer pop() {
		if(dataStack.isEmpty())
			return null;
		minStack.pop();
		return dataStack.pop();
	}
	
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		int[] a = {10,9,8,12,1,8,0};
		for(int i : a) {
			minStack.push(i);
		}
		while(!minStack.dataStack.isEmpty()) {
			System.out.println(minStack.dataStack.pop() + "  " + minStack.min());
		}
	}
}
