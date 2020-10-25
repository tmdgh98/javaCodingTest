package backjun.DivideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MatrixSecond {
	static int[][] matrix;
	static int row;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] rowNum = br.readLine().split(" ");
		row = Integer.parseInt(rowNum[0]);
		long num = Long.parseLong(rowNum[1]);
		matrix = new int[row][row];
		for (int i = 0; i < row; i++) {
			String[] field = br.readLine().split(" ");
			for (int j = 0; j < row; j++) {
				matrix[i][j]=Integer.parseInt(field[j]);
			}
		}
		int[][] answer = divide(num);
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				sb.append(answer[i][j]%1000+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	private static int[][] divide(long num) {
		if(num==1) {
			return matrix;
		}
		int[][] temp = divide(num/2);
		if(num%2==0) {
			return second(temp,temp);
		}else {
			return second(second(temp,temp),matrix);
		}
	}
	
	private static int[][] second(int[][] matrix1, int[][] matrix2) {
		int[][] reMatrix = new int[row][row];
		for (int i = 0; i < row; i++) {
			
			for (int j = 0; j < row; j++) {
				int feild = 0;				
				for (int j2 = 0; j2 < row; j2++) {
					feild += matrix1[i][j2] * matrix2[j2][j];
					feild %= 1000;
				}
				reMatrix[i][j] = feild;
			}
		}
		return reMatrix;
	}
}
