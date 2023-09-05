package baekjoon.backtracking;

import java.util.Scanner;

public class NandM03 {
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		arr = new int[m];
		
		back(n,m,0);
		System.out.println(sb);
	}
	
	public static void back(int n,int m, int depth) {
		if(depth < m) {
			for (int i = 0; i < n; i++) {
				arr[depth] = i+1;
				back(n,m,depth+1);
			}
		}else {
			for(int i : arr) {
				sb.append(i);
				sb.append(' ');
			}
			sb.append('\n');
		}
	}
}
