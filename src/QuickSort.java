
public class QuickSort {

	public static int partition(int[] a,int lo,int hi)
	{
		int i = lo;
		int j = hi+1;
		while(true)
		{
			while(a[++i]<a[lo])
			{
				if(i>=hi) break;
			}

			while(a[--j]>a[lo])
			{
				if(j<=lo) break;
			}
			if (i>=j) {
				break;
			}
			
			swap(a,i,j);

		}
		swap(a,lo,j);
		
		return j;
	}
	
	public static void sort(int[] a,int lo,int hi) {
		if(lo>=hi) return;
		int p = partition(a, lo, hi);
		sort(a, lo, p-1);
		sort(a, p+1, hi);
	}
	
	public static void swap(int[] arr,int i,int j)
	{
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a ={5,8,4,6,12,80,9,9};
		sort(a, 0, a.length-1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
