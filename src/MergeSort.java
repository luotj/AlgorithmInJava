/*
 * 归并排序：用递归的思想来排序，达到分治的目的
 */
public class MergeSort {
	
	public static void mergeArray(int[] a,int[] p,int lo,int mid,int hi)
	{
		for(int k=lo;k<=hi;k++)
			p[k]=a[k];			//数组复制到辅助数组里
		
		int i=lo; int j=mid+1;
		
		for(int k=lo;k<=hi;k++)
		{
			if		(i>mid) 	a[k]=p[j++];
			else if	(j>hi)  	a[k]=p[i++];
			else if	(p[i]>p[j]) a[k]=p[j++];
			else				a[k]=p[i++];
		}
		
	}
	
	public static void sort(int[] a,int[] p,int lo,int hi)
	{
		int mid = (lo+hi)/2;
		
		if(hi-lo<=7)                     //优化:在数组较短时采用插入排序要比归并排序开销小
		{
			InsertSort.sort(a, lo, hi);
			return;
		}
		sort(a,p,lo,mid);
		sort(a,p,mid+1,hi);
		if(a[mid]<a[mid+1])             //优化：数组已经有序时无需再合并了
			return;
		mergeArray(a,p,lo,mid,hi);
	}
	
	public static void sort(int[] a)
	{
		int N = a.length;
		int[] p = new int[N];
		sort(a,p,0,N-1);
	}
	
	public static void main(String[] args)
	{
		int[] a = {0,8,3,6,7,9,1,10,12,4};
		sort(a);
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
	}
	
}
