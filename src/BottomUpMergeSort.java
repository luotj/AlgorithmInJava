/*
 * 归并排序的非递归形式
 */
public class BottomUpMergeSort {

	public static void merge(int[] a,int[] p,int lo,int mid,int hi)
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
	
	public static void sort(int[] a)
	{
		int N = a.length;
		int[] p = new int[N];
		for(int sz=1;sz<N;sz+=sz)
		{
			for(int lo=0;lo<N-sz;lo+=sz+sz)
			{
				merge(a,p,lo,lo+sz-1,Math.min(lo+sz+sz-1, N-1));
			}
		}
	}
	
	public static void main(String[] args)
	{
		int[] a = {1,3,2,5,0};
		sort(a);
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}
}
