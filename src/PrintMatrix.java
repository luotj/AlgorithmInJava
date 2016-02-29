
public class PrintMatrix {

	//顺时针打印矩阵
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
	
	//思路一定要清晰，编程其实考察的还是解决问题的思路，一旦形成清晰的思路，写代码就是很简单的事情了！
	public void printMatrix(int[][] matrix, int xStart, int yStart, int xEnd, int yEnd) {
		//从左到右打印行
		for(int i = yStart; i <= yEnd; i++)
			System.out.print(matrix[xStart][i] + " ");
		//如果要打印的矩阵不止一行则要从上到下打印列
		if(xStart < xEnd) {
			for(int i = 1; i <= xEnd; i++) {
				System.out.print(matrix[i][yEnd] + " ");
			}
			//如果要打印的矩阵不止一列从右到左打印
			if(yStart < yEnd) {
				for(int i = yEnd-1; i >= yStart; i --) {
					System.out.print(matrix[xEnd][i] + " ");
				}
				//如果要打印的矩阵大于2行从下到上打印
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
