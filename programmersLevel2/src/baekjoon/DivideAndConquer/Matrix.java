package baekjoon.DivideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Matrix {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int row=0;
		int column=0;
		int[][] matrix1 = null;
		int[][] matrix2 = null;
		int[][] arr = null;
		int arrrow = 0;
		int arrcolumn = 0;
		for (int i = 0; i < 2; i++) {
			String[] rc = br.readLine().split(" ");
			row = Integer.parseInt(rc[0]);
			column = Integer.parseInt(rc[1]);
			if(i==0) {
				matrix1 = new int[row][column];
				arrrow = row;
				for (int j = 0; j < row; j++) {
					String[] col = br.readLine().split(" ");
					for (int j2 = 0; j2 < column; j2++) {
						matrix1[j][j2]=Integer.parseInt(col[j2]);
					}
				}
			}else {
				matrix2 = new int[row][column];
				arrcolumn=column;
				for (int j = 0; j < row; j++) {
					String[] col = br.readLine().split(" ");
					for (int j2 = 0; j2 < column; j2++) {
						matrix2[j][j2]=Integer.parseInt(col[j2]);
					}
				}
			}
			
		}
		arr = new int[arrrow][arrcolumn];
		int field = 0;
		for (int i = 0; i < arrrow; i++) {
			for (int j = 0; j < arrcolumn; j++) {
				field=0;
				for (int j2 = 0; j2 < row; j2++) {
					field += matrix1[i][j2]*matrix2[j2][j];
				}
				arr[i][j] = field;
				sb.append(field+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
