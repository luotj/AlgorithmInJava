import java.util.Scanner;
import java.util.Stack;

class TreeNode {
	String s;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(String s) {
		this.s = s;
		this.left = null;
		this.right = null;
	}
}

public class Tree {

	TreeNode root;
	
	public void build() {
		Scanner scn = new Scanner(System.in);
		root = createTreeNode(root, scn);
	}
	
	//先序递归创建树
	public TreeNode createTreeNode(TreeNode node,Scanner scn) {
		String temp = scn.next();
		if(temp.equals("#"))
			return null;
		node = new TreeNode(temp);
		node.left = createTreeNode(node.left, scn);
		node.right = createTreeNode(node.right, scn);
		return node;
	}
	
	//给出树的先序遍历和中序遍历实现树的重构
	public void rebuild(String s1, String s2) {
		root = rebuild(root, s1, s2);
	}
	
	public TreeNode rebuild(TreeNode root, String s1, String s2)
	{
		if(s1.equals("") && s2.equals(""))
			return null;
		char c = s1.charAt(0);
		root = new TreeNode(c+"");
		int index = s2.indexOf(c);
		int leftLength = index;
		int rightLength = s2.length()-index-1;
		if(leftLength == 0)
			root.left = rebuild(root.left, "", "");
		else {
			root.left = rebuild(root.left, s1.substring(1, index+1), s2.substring(0, index));
		}
		
		if(rightLength == 0)
			root.right = rebuild(root.right, "", "");
		else {
			root.right = rebuild(root.right, s1.substring(index+1), s2.substring(index+1));
		}
		return root;

	}
	
	//先序遍历递归实现
	public void preOrder() {
		preOrder(root);
	}
	
	
	public void preOrder(TreeNode root) {
		if(root == null)
			return;
		System.out.println(root.s);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	//非递归先序遍历
	public void preOrder1() {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while(!stack.isEmpty() || node != null) {
			while(node != null) {
				System.out.println(node.s);
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			node = node.right;
		}
	}
	
	//中序遍历递归实现
	public void inOrder() {
		inOrder(root);
	}
	
	public void inOrder(TreeNode root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.println(root.s);
		inOrder(root.right);
	}
	
	//中序遍历非递归实现
	public void inOrder1() {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while(node != null || !stack.isEmpty()) {
			while(node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			System.out.println(node.s);
			node = node.right;
		}
	}
	
	//后序遍历递归实现
	public void postOrder() {
		postOrder(root);
	}
	
	public void postOrder(TreeNode root) {
		if(root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.s);
	}
	
	//后序遍历非递归实现
	public void postOrder1() {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		TreeNode visitedNode = null;
		while(node != null || !stack.isEmpty()) {
			while(node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.peek();
			if(node.right == null || node == visitedNode) 
			{
				System.out.println(node.s);
				stack.pop();
				node = null;
			}else {
				visitedNode = node;
				node = node.right;
			}
			
		}
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree();
//		tree.build();
//		tree.postOrder();
		String s1 = "abdec";
		String s2 = "dbeac";
		tree.rebuild(s1, s2);
		tree.postOrder();
	}
	
	
}
