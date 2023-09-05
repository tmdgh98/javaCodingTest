package baekjoon.backtracking;

import java.util.Scanner;

public class NQueen {
	static int[] chess;
	static int count=0;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		chess = new int[n];
	}
	
	public static void queen(int num) {
		if(num==n) {
			count++;
		}else {
			for (int i = 0; i < n; i++) {
				
			}
		}
	}
}
