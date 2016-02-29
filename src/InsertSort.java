/*
 * 插入排序：每次选择右边未排序数组中的第一个数插入到左边的有序数组中
 */
public class InsertSort {
	
	public static void sort(int[] arr, int N)
	{
		for(int i=1;i<N;i++)
		{
			for(int j=i;j>0;j--)
			{
				if(arr[j]<arr[j-1]) swap(arr,j,j-1);
				else break;
			}
		}
	}
	
	public static void sort(int[] arr,int lo,int hi)
	{
		for(int i=lo;i<=hi;i++)
		{
			for(int j=i;j>0;j--)
			{
				if(arr[j]<arr[j-1]) swap(arr,j,j-1);
				else break;
			}
		}
	}
	
	public static void swap(int[] arr,int i,int j)
	{
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,8,5,6,4,2,0};
		sort(a,7);
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}

}
