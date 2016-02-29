
public class PowTest {

	public int pow(int a, int n) {
		if(n == 0)
			return 1;
		if(n == 1)
			return a;
		if(n % 2 == 0) {
			int temp = pow(a, n/2);
			return temp * temp;
		}
		else {
			int temp = pow(a,(n-1)/2);
			return temp * temp * a;
		}
	}
	
	public int[] matrixPow(int[] a, int n) {
		
//		if(n ==0 || n == 1) {
//			return a;
//		}
//		if(n % 2 == 0) {
//			int[] temp = matrixPow(a, n/2);
//			return matrixMult(temp, 2, 2, temp, 2, 2);
//		}
//		else {
//			int[] temp = matrixPow(a, (n-1)/2);
//			return matrixMult(matrixMult(temp, 2, 2, temp, 2, 2), 2, 2, a, 2, 2);
//		}
		
		int[] res = null;
		int[] temp = a;
		while(n > 0) {
			if((n & 1) == 1) {
				if(res == null)
					res = temp;
				else {
					res = matrixMult(res,2,2,temp,2,2);
				}
			}
			temp = matrixMult(temp,2,2,temp,2,2);
			n = n >> 1;
		}
		return res;
	}
	
	public int fibonacci(int n) {
		if(n < 2)
			return n;
		int[] a = {1,1,1,0};
		int[] power = matrixPow(a, n-1);
		int[] b = {1,0};
		int[] res = matrixMult(power, 2, 2, b, 2, 1);
		return res[0];
	}
	
	public int[] matrixMult(int[] a, int aRows, int aCuls, int[] b, int bRows, int bCuls) {
		int[] res = new int[aRows * bCuls];
		for(int i = 0; i < res.length; i++) {
			int resRow = i / bCuls;
			int resCul = i % bCuls;
			int temp = 0;
			for(int j = 0; j < aCuls; j++) {
				temp += a[j + resRow * aCuls] * b[resCul + j * bCuls ];
			}
			res[i] = temp;
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		PowTest powTest = new PowTest();
		System.out.println(powTest.fibonacci(5));

//		System.out.format("%x", -1);
//		int n = -1;
//		int count = 0;
//		while(n != 0) {
//			n = (n - 1) & n;
//			count++;
//		}
//		System.out.println(count);
	}
}
