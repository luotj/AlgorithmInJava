import java.nio.channels.Pipe.SinkChannel;


public class PriorityQueueHeap {
	private int N = 0;
	private int[] PQ;
	
	public PriorityQueueHeap (int capacity) {
		PQ = new int[capacity];
	}
	
	public boolean isEmpty() {
		return N==0;
	}

	public void insert(int item) {
		PQ[++N] = item;
		swim(N);
	}
	
	public int delMax() {
		int max = PQ[1];
		PQ[1]=PQ[N--];
		sink(1);
		return max;
	}
	
	public void sink(int k) {
		
		while(2*k<=N)
		{	
			int j = 2*k;
			
			if(j<N&&PQ[j]<PQ[j+1]) j++;
			if(PQ[k]>=PQ[j]) break;
			swap(PQ, k, j);
			k = j;
		}
	}
	
	public void swim(int k) {
		while(k>1)
		{
			if(PQ[k]>PQ[k/2])
				swap(PQ,k,k/2);
			k=k/2;
		}
	}
	
	
	
	private void swap(int[] arr,int i,int j)
	{
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueueHeap priorityQueueHeap = new PriorityQueueHeap(10);
		for (int i = 0; i < 5; i++) {
			priorityQueueHeap.insert(i);
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println(priorityQueueHeap.delMax());
		}
	}

}
