/*
 * 希尔排序：基于选择排序，在数组基本有序的情况下，选择排序的效率是很高的
 * 所以希尔排序的思想是：按步距分组进行插入排序 
 */
public class ShellSort {
	
	public static void sort(int[] arr)
	{
		int N = arr.length;
		int h=1;
		while(h<N/3) h=3*h+1;//以1,4,7,10,13，、、、的步距进行分组插入排序
		
		while(h>=1)
		{
			for(int i=h;i<N;i++)
			{
				for(int j=i;j-h>=0&&(arr[j]<arr[j-h]);j-=h)
					swap(arr,j,j-h);
			}
			
			h=h/3;
				
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
		sort(a);
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}
}
