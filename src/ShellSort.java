/*
 * ϣ�����򣺻���ѡ������������������������£�ѡ�������Ч���Ǻܸߵ�
 * ����ϣ�������˼���ǣ������������в������� 
 */
public class ShellSort {
	
	public static void sort(int[] arr)
	{
		int N = arr.length;
		int h=1;
		while(h<N/3) h=3*h+1;//��1,4,7,10,13���������Ĳ�����з����������
		
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
