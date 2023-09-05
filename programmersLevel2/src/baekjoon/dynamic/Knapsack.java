package baekjoon.dynamic;

import java.util.Scanner;

public class Knapsack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mWeight = sc.nextInt();
		int[][] arr = new int[n][mWeight+1];
		int weight;
		int value;
		for (int i = 0; i < n; i++) {
			weight = sc.nextInt();
			value = sc.nextInt();
			for (int j = 1; j < mWeight+1; j++) {
				if(i==0) {
					if(weight<=j)
					arr[i][j]=value;
				}else if(weight<=j) {
					arr[i][j]=Math.max(Math.max(arr[i-1][j], arr[i][j-1]),value+arr[i-1][j-weight]);
				}else {
					arr[i][j]=Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
		}
		
		System.out.println(arr[n-1][mWeight]);
	}
}
