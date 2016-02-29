/*
 * 选择排序，每次从未排序的数组中选出一个最小的数放在数组前面
 */
public class SelectSort {

	public static void sort(int[] arr,int N)
	{
		for(int i=0;i<N;i++)
		{
			int min = i;
			for(int j=i+1;j<N;j++)
			{
				if(arr[j]<arr[min]) min=j;
			}
			if(min!=i)
				swap(arr,i,min);
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
