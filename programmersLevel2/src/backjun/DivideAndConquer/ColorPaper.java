
package backjun.DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColorPaper {
	static int[][] arr;
	static int one = 0;
	static int zero = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] sc = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(sc[j]);
			}
		}
		div(0,0,n);
		
		System.out.println(zero);
		System.out.println(one);
	}
	private static void div(int x, int y, int n) {
		if(n==1) {
			plus(x,y);
		}else{
			boolean perfect = true;
			loop:
			for (int j = x; j < x+n; j++) {
				for (int j2 = y; j2 < y+n; j2++) {
					if(arr[x][y]!=arr[j][j2]){
						perfect = false;
						break loop;
					}
				}
			}
			if(perfect) {
				plus(x,y);
			}else {
				div(x,y,n/2);
				div(n/2+x,n/2+y,n/2);
				div(x,n/2+y,n/2);
				div(n/2+x,y,n/2);
			}
		}
	}
	public static void plus(int x, int y) {
		if(arr[x][y]==1) {
			one++;
		}else {
			zero++;
		}
	}
}
