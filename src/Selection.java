/*
 * 给定一个无序数组，找出其中第K大的元素
 * 利用快速排序的partition方法可以实现平均o(n)复杂度
 */
public class Selection {
	
	public static int  partition(int[] a,int lo,int hi) 
	{
		int i = lo;
		int j = hi+1;
		while (true) {
			while(a[++i]<a[lo])
			{
				if(i>=hi) break;
			}
			while (a[--j]>a[lo]) {
				if(j<=lo) break;
			}
			
			if(i>=j)
				break;
			swap(a,i,j);
		}
		swap(a, lo, j);
		return j;
	}
	
	public static int selection(int[] a,int k)
	{
		int lo = 0;
		int hi = a.length-1;
		int j = 0;
		while(true)
		{
			j=partition(a, lo, hi);
			if (j==k-1) {
				break;
			}
			else if(j<k)
			{
				lo=j+1;
			}
			else
			{
				hi = j-1;
			}		
				
		}
		return a[j];
		
	}
	
	public static void swap(int[] arr,int i,int j)
	{
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,1,3,4,5};
		System.out.println(selection(a, 4));
	}

}
