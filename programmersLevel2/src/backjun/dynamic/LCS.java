package backjun.dynamic;

import java.util.Scanner;

public class LCS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		int[][] arr = new int[b.length()+1][a.length()+1];
		for (int i = 1; i < b.length()+1; i++) {
			for (int j = 1; j < a.length()+1; j++) {
				if(b.charAt(i-1) == a.charAt(j-1)) {
					arr[i][j] = arr[i-1][j-1]+1;
				}else {
					arr[i][j] = Math.max(arr[i][j-1],arr[i-1][j]);
				}
			}
		}
		
		System.out.println(arr[b.length()][a.length()]);
	}
}
