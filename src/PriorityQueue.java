/*
 * 优先队列无序数组实现：
 * 优先队列实现优先级最大或者最小的元素先出列
 */
public class PriorityQueue {

	private int N=0;
	private int[] PQ;
	public PriorityQueue (int capacity) {
		PQ = new int[capacity];
	}
	
	public boolean isEmpty() {
		return N==0;

	}
	
	public void insert(int item)
	{
		PQ[N++]=item;
	}
	
	public int delMax() {
		int max = 0;
		for(int i=0;i<N;i++)
		{
			if(PQ[i]>PQ[max])
				max = i;
		}
		swap(PQ, N-1, max);
		
		return PQ[--N];
	}
	
	private void swap(int[] arr,int i,int j)
	{
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void main(String [] args) {
		
		PriorityQueue pq = new PriorityQueue(10);
		for(int i=0;i<8;i++)
			pq.insert(10-i);
		
		for (int i = 0; i < 8; i++) {
			System.out.println(pq.delMax());
		}
		
	}

}
