package backjun.solve;

import java.util.Scanner;

public class President {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int h= 0; h < n; h++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int[][] arr = new int[x+1][y+1];
			for (int i = 0; i <= x; i++) {
				for (int j = 0; j <= y; j++) {
					if(i==0) arr[i][j]=j;
					else if(j==0) {
						arr[i][j]=0;
					}else {
						arr[i][j]=arr[i-1][j]+arr[i][j-1];
					}
					
					if(i==x&&j==y) {
						System.out.println(arr[i][j]);
					}
					
				}
			}
		}
	}
}
