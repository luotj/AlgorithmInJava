import java.util.*;

/*
 * 利用栈实现带括号四则混合运算
 */
public class ArithmeticExpressionEvaluation {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		while (!StdIn.isEmpty()) {
		String s = StdIn.readString();
//		if(s.equals("/n")) break;
//		if (s.equals("(")) ;
//		else if (s.equals("+")) ops.push(s);
//		else if (s.equals("*")) ops.push(s);
//		else if (s.equals(")"))
//		{
//		String op = ops.pop();
//		if (op.equals("+")) vals.push(vals.pop() + vals.pop());
//		else if (op.equals("*")) vals.push(vals.pop() * vals.pop());
//		}
//		else vals.push(Double.parseDouble(s));
		ops.push(s);
//		if(s.equals("a")) break;
		}
		StdOut.println(ops.pop());
		StdOut.println(ops.pop());
		StdOut.println(ops.pop());
		StdOut.println(ops.pop());
	}

}
