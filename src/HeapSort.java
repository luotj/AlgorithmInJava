/*
 * ∂—≈≈–Ú
 */
public class HeapSort {

	public static void sink(int[] a,int k,int N) {
		while(2*k<=N)
		{
			int j = 2*k;
			if(j<N&&a[j-1]<a[j]) j++;
			if(a[k-1]>a[j-1]) break;
			swap(a,k-1,j-1);
			k = j;
		}
	}
	
	public static void sort(int[] a,int N) {
		for(int i=N/2;i>=1;i--)
		{
			sink(a, i, N);
		}
		
		while(N>1)
		{
			swap(a, 0, --N);
			sink(a, 1, N);
		}
		
	}
	
	private static void swap(int[] arr,int i,int j)
	{
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {10,5,6,4,2,1,8,11};
		sort(a, 8);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
