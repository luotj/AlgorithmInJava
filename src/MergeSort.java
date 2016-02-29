/*
 * �鲢�����õݹ��˼�������򣬴ﵽ���ε�Ŀ��
 */
public class MergeSort {
	
	public static void mergeArray(int[] a,int[] p,int lo,int mid,int hi)
	{
		for(int k=lo;k<=hi;k++)
			p[k]=a[k];			//���鸴�Ƶ�����������
		
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
		
		if(hi-lo<=7)                     //�Ż�:������϶�ʱ���ò�������Ҫ�ȹ鲢������С
		{
			InsertSort.sort(a, lo, hi);
			return;
		}
		sort(a,p,lo,mid);
		sort(a,p,mid+1,hi);
		if(a[mid]<a[mid+1])             //�Ż��������Ѿ�����ʱ�����ٺϲ���
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
