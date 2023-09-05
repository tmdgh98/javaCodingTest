package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RGB {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] rgb = new String[3];
		int[][] ans = new int[n][3];
		for (int i = 0; i < n; i++) {
			rgb = br.readLine().split(" ");
			if(i==0) {
				ans[i][0]=Integer.parseInt(rgb[0]);
				ans[i][1]=Integer.parseInt(rgb[1]);
				ans[i][2]=Integer.parseInt(rgb[2]);
			}else {
				ans[i][0]=Math.min(ans[i-1][1], ans[i-1][2])+Integer.parseInt(rgb[0]);
				ans[i][1]=Math.min(ans[i-1][0], ans[i-1][2])+Integer.parseInt(rgb[1]);
				ans[i][2]=Math.min(ans[i-1][1], ans[i-1][0])+Integer.parseInt(rgb[2]);
			}
		}
		
		int answer = Math.min(Math.min(ans[n-1][0], ans[n-1][1]),ans[n-1][2]);
		System.out.println(answer);
		
	}
}
