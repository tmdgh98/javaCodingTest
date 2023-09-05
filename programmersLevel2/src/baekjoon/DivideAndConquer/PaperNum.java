//9
//0 0 0 1 1 1 -1 -1 -1
//0 0 0 1 1 1 -1 -1 -1
//0 0 0 1 1 1 -1 -1 -1
//1 1 1 0 0 0 0 0 0
//1 1 1 0 0 0 0 0 0
//1 1 1 0 0 0 0 0 0
//0 1 -1 0 1 -1 0 1 -1
//0 -1 1 0 1 -1 0 1 -1
//0 1 -1 1 0 -1 0 1 -1
package baekjoon.DivideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PaperNum {
	static int[][] arr;
	static int minus= 0;
	static int zero = 0;
	static int one = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr= new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {	
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		nine(n);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(one);
	}
	private static void nine(int n) {
		nine(0,0,n);
		
	}
	private static void nine(int x, int y, int n) {
		if(n==1) {
			plus(arr[x][y]);
		}else {
			boolean next = true;
			loop:
			for (int i = x; i < x+n; i++) {
				for (int j = y; j < y+n; j++) {
					if(arr[x][y]!=arr[i][j]) {
						next = false;
						break loop;
					}
				}
			}
			if(next) {
				plus(arr[x][y]);
			}else {
				nine(x,y,n/3);
				nine(x+n/3,y,n/3);
				nine(x+2*n/3,y,n/3);
				nine(x+n/3,y+n/3,n/3);
				nine(x+n/3,y+2*n/3,n/3);
				nine(x+2*n/3,y+n/3,n/3);
				nine(x+2*n/3,y+2*n/3,n/3);
				nine(x,y+n/3,n/3);
				nine(x,y+2*n/3,n/3);
			}
		}
		
	}
	private static void plus(int n) {
		if(n==-1) {
			minus++;
		}else if(n==1) {
			one++;
		}else {
			zero++;
		}
	}
	
}
