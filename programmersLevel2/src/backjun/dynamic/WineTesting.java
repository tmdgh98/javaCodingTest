package backjun.dynamic;

import java.util.Scanner;

public class WineTesting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int wine = sc.nextInt();
		int[][] arr = new int[n+1][3];
		
		//0 > x 1 > o 2 > oo
		arr[0][0] = 0;
		arr[0][1] = wine;
		arr[0][2] = 0;
		for (int i = 0; i < n-1; i++) {
			wine = sc.nextInt();
			arr[i+1][1] = arr[i][0]+wine;
			arr[i+1][2] = arr[i][1]+wine;
			arr[i+1][0] = Math.max(Math.max(arr[i][0], arr[i][1]),arr[i][2]);
		}
		
		int max = Math.max(Math.max(arr[n-1][2], arr[n-1][1]),arr[n-1][0]);
		System.out.println(max);
	}
}
