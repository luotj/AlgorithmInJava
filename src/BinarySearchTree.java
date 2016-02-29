import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node
{
	int key;
	int value;
	Node left = null;
	Node right = null;
	
	Node(int key,int value)
	{
		this.key = key;
		this.value = value;
	}
	
}
public class BinarySearchTree
{
	public Node root;
	
	public void put(int key,int value)
	{
		root = put(root, key,value);
	}
	
	private Node put(Node root,int key,int value)
	{
		
		if(root == null)
		{
			Node node =new Node(key, value);
			return node;
		}
		
		else if(key<root.key) 	root.left = put(root.left,key, value);
		else 			 		root.right = put(root.right,key, value);
		return root;
	}
	
	public int get(int key)
	{
		int value = -1;
		Node temp = root;
		while(temp!=null)
		{
			if(key<temp.key)		temp = temp.left;
			else if(key>temp.key)	temp = temp.right;
			else 					
			{
				value= temp.value;
				break;
			}
		}
		return value;
	}
	
	public void delete(int key)
	{
		
	}
	
	public void setNode(Node node,int key,int value)
	{
		node.key = key;
		node.value = value;
		
	}
	
	public static void main(String[] args)
	{
		BinarySearchTree bst = new BinarySearchTree();
		int[] a = {5,2,8,4,3,6};
		for(int i=0;i<a.length;i++)
		{
			bst.put(a[i], i);
		}
		System.out.println(bst.get(8));
	}
}


//class Key implements Comparable<Key>{
//	
//	private String s;
//	public Key (String s) {
//		this.s = s;
//	}
//	@Override
//	public int compareTo(Key that) {
//		// TODO Auto-generated method stub
//		return this.s.compareTo(that.s);
//	}
//	
//}
//
//class Value{
//	private String s;
//	public Value(String string) {
//		this.s=string;
//	}
//	public String getString () {
//		return s;
//	}
//}
//
//public class BinarySearchTree {
//	
//	private class Node{
//		Key key;
//		Value value;
//		Node left;
//		Node right;
//		public Node(Key key,Value value) {
//			this.key = key;
//			this.value = value;
//		}
//	}
//	
//	private Node root;
//	
//	public void put(Key key,Value value)
//	{
//		root = put(root, key,value);
//	}
//	
//	private  Node put(Node root,Key key,Value value)
//	{
//		
//		if(root == null) return new Node(key, value);
//		int cmp = root.key.compareTo(key);
//		if(cmp>0)
//			root.left=put(root.left, key,value);
//		else if(cmp<0)
//			root.right=put(root.right,key,value);
//		else {
//			root.value = value;
//		}
//		return root;
//	}
//	
//	public Value get(Key key)
//	{
//		if(root==null)
//			return null;
//		Node t = root;
//		while(t!=null)
//		{
//			int cmp = root.key.compareTo(key);
//			if(cmp<0) t=t.right;
//			else if(cmp>0) t=t.left;
//			else {
//				return t.value;
//			}
//				
//		}
//		return null;
//		
//	}
//
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		BinarySearchTree bst = new BinarySearchTree();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		System.out.println("ÇëÊäÈë4¸öÊý×Ö£º");
//		//for (int i = 0; i <4; i++) {
//			String k = br.readLine();
//			String v = br.readLine();
//			Key key1 = new Key(k);
//			Value value1 = new Value(v);
//			bst.put(key1, value1);
//			
//			k = br.readLine();
//			v = br.readLine();
//			Key key2 = new Key(k);
//			Value value2 = new Value(v);
//			bst.put(key2, value2);
//		//}
//
//		System.out.println(bst.get(key2).getString());
//	}
//
//}

