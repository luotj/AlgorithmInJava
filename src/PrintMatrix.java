
public class PrintMatrix {

	//˳ʱ���ӡ����
	public void clockwisePrint(int[][] matrix) {
		if(matrix == null)
			return;
		int xEnd = matrix.length - 1;
		int yEnd = matrix[0].length -1;
		int xStart = 0;
		int yStart = 0;
		while(xStart <= xEnd && yStart <= yEnd) {
			printMatrix(matrix, xStart, yStart, xEnd, yEnd);
			xStart ++;
			yStart ++;
			xEnd --;
			yEnd --;
		}
	}
	
	//˼·һ��Ҫ�����������ʵ����Ļ��ǽ�������˼·��һ���γ�������˼·��д������Ǻܼ򵥵������ˣ�
	public void printMatrix(int[][] matrix, int xStart, int yStart, int xEnd, int yEnd) {
		//�����Ҵ�ӡ��
		for(int i = yStart; i <= yEnd; i++)
			System.out.print(matrix[xStart][i] + " ");
		//���Ҫ��ӡ�ľ���ֹһ����Ҫ���ϵ��´�ӡ��
		if(xStart < xEnd) {
			for(int i = 1; i <= xEnd; i++) {
				System.out.print(matrix[i][yEnd] + " ");
			}
			//���Ҫ��ӡ�ľ���ֹһ�д��ҵ����ӡ
			if(yStart < yEnd) {
				for(int i = yEnd-1; i >= yStart; i --) {
					System.out.print(matrix[xEnd][i] + " ");
				}
				//���Ҫ��ӡ�ľ������2�д��µ��ϴ�ӡ
				if(xEnd - xStart > 1) {
					for(int i = xEnd -1; i > xStart; i --) {
						System.out.print(matrix[i][yStart] + " ");
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		PrintMatrix printMatrix = new PrintMatrix();
		int[][] matrix = {{1},{2}};
		printMatrix.clockwisePrint(matrix);
		
	}
}
