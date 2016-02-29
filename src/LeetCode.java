import java.util.*;


public class LeetCode {
	
	public static int lengthOfLongestSubstring1(String s) {
        int maxLen = 0;
        int [] lastIndices = new int[256];//相当于所有字符的哈希表 lastIndices[char]即为该char所对应的值
        for(int i=0;i<256;i++)
        	lastIndices[i] = -1;
        
        int start = 0;
        int curLen = 0;
        
        for(int i=0;i<s.length();i++)
        {
        	char cur = s.charAt(i);
        	if(lastIndices[cur]<start)
        	{
        		lastIndices[cur] = i;
        		curLen++;
        	}
        	else
        	{
        		start = lastIndices[cur]+1;
        		curLen = i-start+1;
        		lastIndices[cur]=i;
        	}
        	
        	if(maxLen<curLen)
        		maxLen = curLen;
        }
        
        return maxLen;
    }
	
	public static int lengthOfLongestSubstring2(String s)
	{
		Set<Character> set = new HashSet<Character>();
		int i=0;
		int j=0;
		int maxLen = 0;
		while(j<s.length())
		{
			if(!set.contains(s.charAt(j)))
			{
				set.add(s.charAt(j++));
				maxLen = Math.max(maxLen, set.size());
			}
			
			else
			{
				set.remove(s.charAt(i++));
			}
		}
		return maxLen;
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;
        int[] p = new int[N1+N2];
        int mid1 = 0;
        int mid2 = 0;
        int i=0;int j=0;
        for(int k=0;k<p.length;k++ )
        {
            if(i>=N1)
            {
                p[k]=nums2[j++];
                if((N1+N2)%2==0)
                {
                    if(k==(N1+N2)/2-1)
                        mid1 = p[k];
                    if(k==(N1+N2)/2)
                        mid2 = p[k];
                }
                else
                {
                    if(k==(N1+N2)/2)
                        mid1 = p[k];
                }
            }
            else if(j>=N2)
            {
                p[k]=nums1[i++];
                if((N1+N2)%2==0)
                {
                    if(k==(N1+N2)/2-1)
                        mid1 = p[k];
                    if(k==(N1+N2)/2)
                        mid2 = p[k];
                }
                else
                {
                    if(k==(N1+N2)/2)
                        mid1 = p[k];
                }
            }
            else if(nums1[i]<nums2[j])
            {
                p[k]=nums1[i++];
                if((N1+N2)%2==0)
                {
                    if(k==(N1+N2)/2-1)
                        mid1 = p[k];
                    if(k==(N1+N2)/2)
                        mid2 = p[k];
                }
                else
                {
                    if(k==(N1+N2)/2)
                        mid1 = p[k];
                }
            }
            else
            {
                p[k]=nums2[j++];
                if((N1+N2)%2==0)
                {
                    if(k==(N1+N2)/2-1)
                        mid1 = p[k];
                    if(k==(N1+N2)/2)
                        mid2 = p[k];
                }
                else
                {
                    if(k==(N1+N2)/2)
                        mid1 = p[k];
                }
            }
        }
        if((N1+N2)%2==0)
            return (mid1+mid2)/2.0;
        return mid1;
    }
	
	public static double findMedianSortedArrays1(int[] nums1, int[] nums2)
	{
		int m=nums1.length;
		int n=nums2.length;
		int[] A = nums1;
		int[] B = nums2;
		if(nums1.length>nums2.length)
		{
			A = nums2;	m = nums2.length;
			B = nums1;	n = nums1.length;
		}
		int mid1=0;
		int mid2=0;
		int imin = 0;
		int imax = m;
		int half = (m+n+1)/2;
		while(imin<=imax)
		{
			int i = (imin+imax)/2;
			int j = half-i;
			
			if(i>0&&j<n&&A[i-1]>B[j])
				imax = i-1;
			else if(j>0&&i<m&&B[j-1]>A[i])
				imin = i+1;
			else
			{
				if(i==0)
					mid1 = B[j-1];
				else if(j==0)
					mid1 = A[i-1];
				else
					mid1=Math.max(B[j-1], A[i-1]);
				
				if((m+n)%2==1)
				{
					mid2=mid1;
					break;
				}
					
				
				if(i==m)
					mid2 = B[j];
				else if(j==n)
					mid2 = A[i];
				else
					mid2 = Math.min(A[i], B[j]);
				
				break;
			}
				
		}
		return (mid1+mid2)/2.0;
	}
	public static void main(String args[]) {
		
//		String s = "abcdeab";
//		System.out.print(lengthOfLongestSubstring2(s));
		int a[]={2,4,6,9};
		int b[]={9,10,11,12,1};
		double d = findMedianSortedArrays1(a,b);
		System.out.println(d);
	}
}
