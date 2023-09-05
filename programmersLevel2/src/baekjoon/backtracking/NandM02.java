package baekjoon.backtracking;

import java.util.Scanner;

public class NandM02 {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		arr = new int[m];
		
		backtracking(n, m, 0, 0);
	}
	
	public static void backtracking(int n, int m, int depth, int start) {
		if(depth < m) {
			for (int i = start; i < n; i++) {
				arr[depth] = i+1;
				start++;
				backtracking(n, m, depth+1, start);
			}
		}else {
			for(int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
