package baekjoon.DivideAndConquer;

import java.util.Scanner;

public class QuadTree {
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String row = sc.next();
			for (int j = 0; j < n; j++) {
				arr[i][j] = row.charAt(j);
			}
		}
//		sb.append('(');
		quad(n);
//		sb.append(')');
		System.out.println(sb);
	}
	public static void quad(int n) {
		quad(0,0,n,"mid");
	}
	public static void quad(int x, int y, int n, String fml) {
		if(n==1) {
			print(x,y,fml);
		}else {
			boolean div = false;
			loop:
			for (int i = x; i < x+n; i++) {
				for (int j = y; j < y+n; j++) {
					if(arr[x][y]!=arr[i][j]) {
						div = true;
						break loop;
					}
				}
			}
			if(div) {
				if(fml.equals("first")) {
					sb.append("(");
				}
				quad(x,y,n/2,"first");
				quad(x,y+n/2,n/2,"mid");
				quad(x+n/2,y,n/2,"mid");
				quad(x+n/2,y+n/2,n/2,"last");
				if(fml.equals("last")) {
					sb.append(")");
				}
			}else {
				print(x,y,fml);
			}
		}
	}
	
	public static void print(int x,int y, String fml) {
		if(fml.equals("first")) {
			sb.append("(");
		}
		if(arr[x][y]=='1') {
			sb.append(1);
		}else {
			sb.append(0);
		}
		if(fml.equals("last")) {
			sb.append(")");
		}
	}
}
